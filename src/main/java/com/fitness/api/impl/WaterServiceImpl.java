package com.fitness.api.impl;

import com.fitness.api.dao.WaterDao;
import com.fitness.api.domain.Water;
import com.fitness.api.service.WaterService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2017/8/1.
 */
@Service
public class WaterServiceImpl implements WaterService, PageService {

    @Autowired
    private WaterDao waterDao;

    /**
     * 创建
     *
     * @param water
     * @return
     */
    @Override
    public BaseResult add(Water water) {
        Integer result = waterDao.add(water);
        if (result > 0)
            return BaseResult.success("新增成功");
        return BaseResult.error("ADD_FAIL", "新增失败");
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        Integer result = waterDao.del(id);
        if (result > 0)
            return BaseResult.success("删除成功");
        return BaseResult.error("DELETE_FAIL", "删除失败");
    }

    /**
     * 修改
     *
     * @param water
     * @return
     */
    @Override
    public BaseResult update(Water water) {
        Integer result = waterDao.update(water);
        if (result > 0)
            return BaseResult.success("修改成功");
        return BaseResult.error("UPDATE_FAIL", "修改失败");
    }

    /**
     * 列表  分页 模糊查询
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        if (!StringUtils.isNullOrEmpty(key))
            key = "%" + key + "%";
        Integer count = waterDao.count(key);
        if (count <= 0)
            return new PageResult(null, 0);
        List<Water> list = waterDao.list(rowBounds(pageNo, pageSize), key);
        return new PageResult(list, count, pageNo, pageSize);
    }
}
