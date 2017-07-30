package com.fitness.api.controller;

import com.fitness.api.domain.Meal;
import com.fitness.api.service.MealService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 餐饮-api
 * Created on 2017/7/29.
 */
@RestController
@RequestMapping("meal")
public class MealController {

    @Autowired
    private MealService mealService;

    /**
     * 新增餐饮
     *
     * @param meal
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody Meal meal) {
        return mealService.add(meal);
    }

    /**
     * 查询餐饮列表
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        return mealService.list(pageNo, pageSize, key);
    }

    /**
     * 根据场馆查询营养餐
     *
     * @param stadiumId
     * @return
     */
    @RequestMapping(value = "/listByStadiumId", method = RequestMethod.GET)
    public BaseResult listByStadiumId(Long stadiumId) {
        return mealService.listByStadiumId(stadiumId);
    }


    /**
     * 修改
     *
     * @param meal
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody Meal meal) {
        return mealService.update(meal);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResult del(Long id) {
        return null;
    }
}
