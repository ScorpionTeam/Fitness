package com.fitness.api.impl;

import com.fitness.api.domain.PrivateClass;
import com.fitness.api.service.PrivateClassService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import org.springframework.stereotype.Service;

/**
 * 私教课业务逻辑层
 * Created on 2017/7/1.
 */
@Service
public class PrivateClassServiceImpl implements PrivateClassService,PageService {

    /**
     * 创建课程
     * @param privateClass
     * @return
     */
    @Override
    public BaseResult add(PrivateClass privateClass) {
        return null;
    }

    /**
     * 根据id删除课程
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        return null;
    }

    /**
     * 根据教练id 查询课程列表  分页
     * @param pageNo
     * @param pageSize
     * @param coachId
     * @return
     */
    @Override
    public PageResult listByCoachId(Integer pageNo, Integer pageSize, Long coachId) {
        return null;
    }

    /**
     * 修改课程
     * @param privateClass
     * @return
     */
    @Override
    public BaseResult update(PrivateClass privateClass) {
        return null;
    }

    /**
     * 根据会员id  查询我的课程  分页
     * @param pageNo
     * @param pageSize
     * @param memberId
     * @return
     */
    @Override
    public PageResult myClass(Integer pageNo, Integer pageSize, Long memberId) {
        return null;
    }

    /**
     * 根据课程id查看详情
     * @param id
     * @return
     */
    @Override
    public BaseResult coachClassInfo(Long id) {
        return null;
    }
}
