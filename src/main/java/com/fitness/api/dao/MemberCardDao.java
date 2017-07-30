package com.fitness.api.dao;

import com.fitness.api.domain.MemberCard;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员卡数据访问层
 * Created on 2017/7/2.
 */
@Repository
public interface MemberCardDao {

    /**
     * 创建会员卡
     *
     * @param memberCard
     */
    void add(MemberCard memberCard);

    /**
     * 修改会员卡
     *
     * @param memberCard
     */
    Integer update(MemberCard memberCard);

    /**
     * 根据会员卡id 删除会员卡
     *
     * @param id
     */
    void del(@Param(value = "id") Long id);

    /**
     * 根据会员卡卡号查询 会员卡列表  分页
     *
     * @param rowBounds
     * @param key
     * @return
     */
    List<MemberCard> list(RowBounds rowBounds, @Param(value = "key") String key);

    /**
     * 查询会员数量
     *
     * @param key
     * @return
     */
    Integer count(@Param(value = "key") String key);

    /**
     * 根据会员卡id 查询会员卡详情
     *
     * @param id
     * @return
     */
    MemberCard memberCardInfo(@Param(value = "id") Long id);

    /**
     * 根据卡类型 type 查询可用会员卡
     *
     * @param type
     * @return
     */
    MemberCard availableMemberCard(@Param(value = "type") String type);

    /**
     * 根据会员卡id  修改状态
     * @param id
     * @param status
     */
    void updateMemberCardStatus(@Param(value = "id") Long id,@Param(value = "status") String status);

    /**
     * 根据场馆id 查询会员卡列表
     * @param stadiumId
     * @return
     */
    List<MemberCard> cardList(@Param(value = "stadiumId")Long stadiumId);

    /**
     * 根据会员id修改剩余课程
     * @param memberId
     * @return
     */
    Integer updateCLassSurplus(@Param(value = "memberId")Long memberId);
}
