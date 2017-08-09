package com.fitness.api.dao;

import com.fitness.api.domain.Coach;
import com.fitness.api.domain.PrivateClass;
import com.fitness.api.dto.PrivateClassDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 私教课数据访问层
 * Created on 2017/7/1.
 */
@Repository
public interface PrivateClassDao {

    /**
     *  新增私教课程
     * @param privateClass
     * @return
     */
    int insertPrivateClass(PrivateClass privateClass);

    /**
     * 根据id删除私教课
     * @param id
     * @return
     */
    int del(Long id);

    /**
     *
     * @param 修改教练开课状态
     * @return
     */
    int updateCoachStatus(Coach coach);

    /**
     * 修改私教课
     * @param privateClass
     * @return
     */
    int updatePrivateClass(PrivateClass privateClass);

    /**
     *  根据教练id 查询课程列表数量
     * @param coachId
     * @return
     */
    Integer listByCoachIdCount(Long coachId);

    /**
     * 根据教练id 查询课程列表
     * @param rowBounds
     * @param coachId
     * @return
     */
    List<PrivateClassDTO> listByCoachId(RowBounds rowBounds,Long coachId);


}
