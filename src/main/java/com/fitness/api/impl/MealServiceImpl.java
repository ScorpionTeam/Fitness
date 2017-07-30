package com.fitness.api.impl;

import com.fitness.api.dao.MealDao;
import com.fitness.api.domain.Meal;
import com.fitness.api.service.MealService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 餐饮业务逻辑层
 * Created on 2017/7/29.
 */
@Service
public class MealServiceImpl implements MealService, PageService {

    @Autowired
    private MealDao mealDao;

    /**
     * 新增餐饮
     *
     * @param meal
     * @return
     */
    @Override
    public BaseResult add(Meal meal) {
        Meal valid = mealDao.validByName(meal.getName(), meal.getStadiumId());
        if (null != valid)
            return BaseResult.error("ADD_FAIL", "名称已存在");
        Integer result = mealDao.add(meal);
        if (result > 0)
            return BaseResult.success("新增餐饮成功");
        return BaseResult.error("ADD_FAIL", "新怎餐饮失败");
    }


    /**
     * 餐饮列表 分页
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

        Integer count = mealDao.count(key);
        if (count <= 0)
            return new PageResult(null, 0);
        List<Meal> list = mealDao.list(rowBounds(pageNo, pageSize), key);
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 根据场馆id获取营养餐列表
     *
     * @param stadiumId
     * @return
     */
    @Override
    public BaseResult listByStadiumId(Long stadiumId) {
        List<Meal> list = mealDao.listByStadiumId(stadiumId);
        if (null == list && list.size() <= 0)
            return BaseResult.nonSuchResult();
        return BaseResult.success(list);
    }

    /**
     * @param meal 餐饮
     * @return
     */
    @Override
    public BaseResult update(Meal meal) {
        Meal valid = mealDao.validByName(meal.getName(), meal.getStadiumId());
        if (null != valid)
            return BaseResult.error("UPDATE_FAIL", "名称已存在");
        Integer result = mealDao.update(meal);
        if (result > 0)
            return BaseResult.success("修改成功");
        return BaseResult.error("UPDATE_FAIL", "修改失败");
    }

    /**
     * @param id 餐饮id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        Integer result = mealDao.del(id);
        if (result > 0)
            return BaseResult.success("删除成功");
        return BaseResult.error("DELETE_FAIL", "删除失败");
    }


}
