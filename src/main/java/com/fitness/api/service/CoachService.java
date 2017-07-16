package com.fitness.api.service;

import com.fitness.api.domain.Coach;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * 教练业务逻辑接口
 * Created on 2017/7/12.
 */
public interface CoachService {

    /**
     * 新增教练
     * @param coach
     * @return
     */
    BaseResult add(Coach coach);

    /**
     * 教练列表
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    PageResult list(Integer pageNo,Integer pageSize,String key);

    /**
     * 根据教练id 查询教练详情
     * @param id
     * @return
     */
    BaseResult coachInfo(Long id);

    /**
     * 修改教练信息
     * @param coach
     * @return
     */
    BaseResult update(Coach coach);

    /**
     * 根据教练id删除教练信息
     * @param id
     * @return
     */
    BaseResult del(Long id);

    /**
     * 根据场馆id查询教练集合
     * @param stadiumId
     * @return
     */
    BaseResult coachListByStadiumId(Long stadiumId);
}
