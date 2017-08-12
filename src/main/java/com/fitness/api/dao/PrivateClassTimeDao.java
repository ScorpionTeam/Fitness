package com.fitness.api.dao;

import com.fitness.api.domain.PrivateClassTime;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by THINK on 2017/7/23.
 */
@Repository
public interface PrivateClassTimeDao {

    /**
     * 批量新增私教时刻表
     * @param list
     * @return
     */
    Integer batchInsertPrivateClassTime(@Param(value = "list") List<PrivateClassTime> list);

    /**
     * 更新私教课时刻表
     * @param privateClassTime
     * @return
     */
    int updatePrivateClassTime(PrivateClassTime privateClassTime);

    /**
     * 根据私教课id查询 私教课时间段
     * @param privateClassId
     * @return
     */
    List<PrivateClassTime> classTimesById(Long privateClassId);

    /**
     * 修改时间段状态为 已定
     * @param timeId
     * @return
     */
    Integer updateTimeStatus(@Param(value = "timeId") Long timeId);
}
