package com.fitness.api.dao;

import com.fitness.api.domain.Coach;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 教练数据访问层
 * Created on 2017/7/2.
 */
@Repository
public interface CoachDao {

    /**
     * 查询列表总数
     *
     * @param key
     * @return
     */
    Integer count(@Param(value = "key") String key);

    /**
     * 根据关键字查询列表  分页
     *
     * @param rowBounds
     * @param key
     * @return
     */
    List<Coach> list(RowBounds rowBounds, @Param(value = "key") String key);

    /**
     * 新增教练
     *
     * @param coach
     * @return
     */
    Integer add(Coach coach);

    /**
     * 根据教练id  删除教练
     *
     * @param id
     * @return
     */
    Integer del(Long id);

    /**
     * 修改教练信息
     *
     * @param coach
     * @return
     */
    Integer update(Coach coach);

    /**
     * 根据id查询教练详情
     *
     * @param id
     * @return
     */
    Coach coachInfo(@Param(value = "id") Long id);

    /**
     * 根据场馆id查询教练集合
     * @param stadiumId
     * @return
     */
    List<Coach> coachListByStadiumId(@Param(value = "stadiumId")Long stadiumId);
}
