package com.fitness.api.impl;

import com.alibaba.fastjson.JSON;
import com.fitness.api.dao.MemberCardDao;
import com.fitness.api.dao.MemberDao;
import com.fitness.api.domain.Member;
import com.fitness.api.domain.MemberCard;
import com.fitness.api.domain.Oath;
import com.fitness.api.service.MemberService;
import com.fitness.constant.Constant;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import com.fitness.util.OathUtil;
import com.fitness.util.PBKUtils;
import com.mysql.jdbc.StringUtils;
import com.mysql.jdbc.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 会员业务逻辑
 * Created on 2017/7/1.
 */
@Service
public class MemberServiceImpl implements MemberService, PageService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberCardDao memberCardDao;


    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    @Override
    public BaseResult login(String phone, String password) throws Exception {

        //password加密
        String pass = PBKUtils.getEncryptedPassword(password, Constant.ENCRYPT_SALT);

        //根据账号密码查询数据库对象
        Member member = memberDao.login(phone, pass);

        if (null == member)
            return BaseResult.error("LOGIN_FAIL", "手机号或密码错误");

        if (member.getStatus().equals("2"))
            return BaseResult.error("IN_AUDIT", "审核中");

        if (member.getStatus().equals("3"))
            return BaseResult.error("AUDIT_FAIL", "审核失败");

        if (member.getStatus().equals("4"))
            return BaseResult.error("LOGIN_FAIL", "账号不存在");

        //写入redis缓存
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(Constant.ON_LINE + phone, JSON.toJSONString(member), 60, TimeUnit.MINUTES);

        //生成加密授权码
        String oath = OathUtil.aesEncrypt(phone, Constant.OATH_KEY);
        Oath oathObj = new Oath();
        oathObj.setOath(oath);
        oathObj.setMember(member);

        return BaseResult.success(oathObj);
    }

    /**
     * 注册
     *
     * @param member
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResult register(Member member) throws Exception {
        Integer result = memberDao.checkPhoneForRegister(member.getPhone());

        if (result > 0)
            return BaseResult.error("USER_EXIST", "账号已存在");

        if (StringUtils.isNullOrEmpty(member.getPassword()))
            member.setPassword(Constant.DEFAULT_PASSWORD);
        String password = PBKUtils.getEncryptedPassword(member.getPassword(), Constant.ENCRYPT_SALT);
        member.setPassword(password);
        Integer result1 = memberDao.register(member);
        if (result1 > 0) {
            if (!StringUtils.isNullOrEmpty(member.getMemberCardId().toString())) {
                //将会员卡状态修改为已绑定
                memberCardDao.updateMemberCardStatus(member.getMemberCardId(), "2");
                return BaseResult.success("注册成功");
            }
        }
        return BaseResult.error("REGISTER_FAIL", "注册失败");
    }

    /**
     * 退出
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult logout(Long id) {
        //TODO 清空redis数据
        return BaseResult.success("LOGOUT_SUCCESS");
    }

    /**
     * 修改会员基本信息
     *
     * @param member
     * @return
     */
    @Override
    public BaseResult update(Member member) {
        memberDao.update(member);
        //将会员卡状态修改为已绑定
        memberCardDao.updateMemberCardStatus(member.getMemberCardId(), "2");
        return BaseResult.success("基本信息修改成功");
    }

    /**
     * 修改昵称
     *
     * @param id
     * @param nick
     * @return
     */
    @Override
    public BaseResult updateNick(Long id, String nick) {

        Integer result = memberDao.updateNick(id, nick);

        if (result <= 0)
            return BaseResult.error("UPDATE_NICK_FAIL", "昵称修改失败");

        return BaseResult.success("昵称修改成功");
    }

    /**
     * 审核
     * 绑定会员卡
     *
     * @param member
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResult bindCard(Member member) {
        //审核通过
        if (member.getStatus().equals("1")) {
            //根据会员购买卡类型查询可用卡
            MemberCard memberCard = memberCardDao.availableMemberCard(member.getType());
            if (null == memberCard)
                return BaseResult.error("BIND_CARD_FAIL", "会员卡不足,请补足库存");
            //绑定
            memberDao.bindCard(member.getId(), memberCard.getId());
            //将会员卡状态修改为已绑
            memberCardDao.updateMemberCardStatus(memberCard.getId(), "2");
            return BaseResult.success("BIND_CARD_SUCCESS");
        } else if (member.getStatus().equals("2")) {
            //审核不通过不允许绑定卡
            memberDao.auditFail(member);
            return BaseResult.success("NON_BIND_CARD");
        }
        return BaseResult.error("BIND_CARD_ERROR", "绑卡出错");
    }

    /**
     * 根据会员id 查询会员详情
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult memberInfo(Long id) {
        Member member = memberDao.memberInfo(id);
        if (null == member)
            return BaseResult.nonSuchResult();
        return BaseResult.success(member);
    }

    /**
     * 根据会员id  注销
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult cancel(Long id) {
        Integer result = memberDao.cancel(id);
        if (result > 0)
            return BaseResult.success("注销会员成功");
        return BaseResult.error("CANCEL_SUCCESS","注销会员失败");
    }

    /**
     * 会员列表  关键字搜索
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        if (!StringUtils.isNullOrEmpty(key))
            key = "%" + key + "%";
        Integer count = memberDao.count(key);
        if (count <= 0)
            return new PageResult(null, 0);
        List<Member> list = memberDao.list(rowBounds(pageNo, pageSize), key);

        return new PageResult(list, count, pageNo, pageSize);
    }
}
