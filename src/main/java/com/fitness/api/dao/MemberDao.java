package com.fitness.api.dao;

import com.fitness.api.domain.Member;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员 数据访问层
 * Created on 2017/7/1.
 */
@Repository
public interface MemberDao {

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    Member login(@Param(value = "phone") String phone, @Param(value = "password") String password);

    /**
     * 修改昵称
     *
     * @param id
     * @param nick
     * @return
     */
    Integer updateNick(@Param(value = "id")Long id, @Param(value = "nick")String nick);

    /**
     * 注册
     *
     * @param member
     * @return
     */
    Integer register(Member member);

    /**
     * 修改会员信息
     *
     * @param member
     */
    void update(Member member);

    /**
     * 绑定会员卡
     *
     * @param memberId
     * @param memberCardId
     */
    void bindCard(Long memberId, Long memberCardId);

    /**
     * 根据id查询会员卡详情
     *
     * @param id
     * @return
     */
    Member memberInfo(Long id);

    /**
     * 审核不通过
     *
     * @param member
     */
    void auditFail(Member member);

    /**
     * 根据会员id  注销
     * @param id
     */
    Integer cancel(Long id);

    /**
     * 注册检查手机号
     * @param phone
     * @return
     */
    Integer checkPhoneForRegister(@Param(value = "phone") String phone);

    /**
     * 查询会员数量
     * @param key
     * @return
     */
    Integer count(@Param(value = "key")String key);

    /**
     * 会员列表
     * @param rowBounds
     * @param key
     * @return
     */
    List<Member> list(RowBounds rowBounds,@Param(value = "key")String key);

}
