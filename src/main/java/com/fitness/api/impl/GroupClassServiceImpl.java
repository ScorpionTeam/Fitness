package com.fitness.api.impl;

import com.fitness.api.dao.GroupClassDao;
import com.fitness.api.domain.GroupClass;
import com.fitness.api.service.GroupClassService;
import com.fitness.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 团课-业务逻辑
 * Created on 2017/7/23.
 */
@Service
public class GroupClassServiceImpl implements GroupClassService {

    @Autowired
    private GroupClassDao groupClassDao;


    /**
     * 创建团课
     * @param groupClass
     * @return
     */
    @Override
    public BaseResult add(GroupClass groupClass) {
        return null;
    }

    /**
     * 修改团课
     * @param groupClass
     * @return
     */
    @Override
    public BaseResult update(GroupClass groupClass) {
        return null;
    }

    /**
     * 根据团课id删除
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        return null;
    }

    /**
     * 团课详情
     * @param id
     * @return
     */
    @Override
    public BaseResult classInfo(Long id) {
        return null;
    }
}
