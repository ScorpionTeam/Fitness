package com.fitness.api.impl;

import com.fitness.api.dao.MemberCardDao;
import com.fitness.api.domain.MemberCard;
import com.fitness.api.service.MemberCardService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created on 2017/7/2.
 */
@Service
public class MemberCardServiceImpl implements MemberCardService, PageService {

    @Autowired
    private MemberCardDao memberCardDao;

    /**
     * 创建会员卡
     *
     * @param memberCard
     * @return
     */
    @Override
    public BaseResult add(MemberCard memberCard) {
        //随机生成会员卡卡号
        Calendar calendar = Calendar.getInstance();
        String cardNo = String.valueOf(calendar.getTime().getTime());
        memberCard.setCardNo(cardNo);
        memberCardDao.add(memberCard);
        return BaseResult.success("ADD_SUCCESS");
    }

    /**
     * 修改会员卡
     *
     * @param memberCard
     * @return
     */
    @Override
    public BaseResult update(MemberCard memberCard) {
        memberCardDao.update(memberCard);
        return BaseResult.success("UPDATE_SUCCESS");
    }

    /**
     * 根据会员卡id  删除会员卡
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        memberCardDao.del(id);
        return BaseResult.success("DELETE_SUCCESS");
    }

    /**
     * 根据会员卡id 查询会员卡列表  分页
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
        Integer count = memberCardDao.count(key);
        if (count <= 0)
            return new PageResult(null, 0);
        List<MemberCard> list = memberCardDao.list(rowBounds(pageNo, pageSize), key);

        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 根据会员卡id 查看会员卡详情
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult memberCardInfo(Long id) {
        MemberCard memberCard = memberCardDao.memberCardInfo(id);
        if (null == memberCard)
            return BaseResult.nonSuchResult();
        return BaseResult.success(memberCard);
    }

    /**
     * 根据场馆id查询会员卡列表
     *
     * @param stadiumId
     * @return
     */
    @Override
    public BaseResult cardList(Long stadiumId) {

        List<MemberCard> list = memberCardDao.cardList(stadiumId);
        if (null == list || list.size() <= 0)
            return BaseResult.nonSuchResult();

        return BaseResult.success(list);
    }

}
