package com.fitness.api.impl;

import com.fitness.api.dao.WaterDao;
import com.fitness.api.domain.Water;
import com.fitness.api.service.WaterService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2017/8/1.
 */
@Service
public class WaterServiceImpl implements WaterService,PageService {

    @Autowired
    private WaterDao waterDao;

    /**
     * 创建
     * @param water
     * @return
     */
    @Override
    public BaseResult add(Water water) {
        return null;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        return null;
    }

    /**
     * 修改
     * @param water
     * @return
     */
    @Override
    public BaseResult update(Water water) {
        return null;
    }

    /**
     * 列表  分页 模糊查询
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        return null;
    }
}
