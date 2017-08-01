package com.fitness.api.controller;

import com.fitness.api.domain.Water;
import com.fitness.api.service.WaterService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 水吧-api
 * Created on 2017/8/1.
 */
@RestController
@RequestMapping("water")
public class WaterController {

    @Autowired
    private WaterService waterService;

    /**
     * 列表
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        return waterService.list(pageNo, pageSize, key);
    }

    /**
     * 新增
     *
     * @param water
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody Water water) {
        return waterService.add(water);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResult del(Long id) {
        return waterService.del(id);
    }

    /**
     * 修改
     *
     * @param water
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody Water water) {
        return waterService.update(water);
    }
}
