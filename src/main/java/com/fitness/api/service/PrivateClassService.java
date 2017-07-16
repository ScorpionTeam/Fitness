package com.fitness.api.service;

import com.fitness.api.domain.PrivateClass;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

/**
 * 课程接口
 * Created on 2017/7/1.
 */
public interface PrivateClassService {

    /**
     * 新增课程
     * @param privateClass
     * @return
     */
    BaseResult add(PrivateClass privateClass);

    /**
     * 根据课程id删除课程
     * @param id
     * @return
     */
    BaseResult del(Long id);

    /**
     * 根据教练id 查询课程 分页
     * @param pageNo
     * @param pageSize
     * @param coachId
     * @return
     */
    PageResult listByCoachId(Integer pageNo,Integer pageSize,Long coachId);

    /**
     * 修改课程信息
     * @param privateClass
     * @return
     */
    BaseResult update(PrivateClass privateClass);

    /**
     * 根据会员id 查询我的课程 分页
     * @param pageNo
     * @param pageSize
     * @param memberId
     * @return
     */
    PageResult myClass(Integer pageNo,Integer pageSize,Long memberId);

    /**
     * 根据课程id 查看课程详情
     * @param id
     * @return
     */
    BaseResult coachClassInfo(Long id);
}
