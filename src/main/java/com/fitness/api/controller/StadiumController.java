package com.fitness.api.controller;

import com.fitness.annotations.OathAnnotation;
import com.fitness.api.domain.Stadium;
import com.fitness.api.service.StadiumService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 场馆-api
 * Created on 2017/7/3.
 */
@RestController
@RequestMapping("stadium")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    /**
     * 创建场馆
     *
     * @param stadium
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody Stadium stadium) {
        return stadiumService.add(stadium);
    }

    /**
     * 根据场馆id 删除场馆信息
     *
     * @param id
     * @return
     */

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public BaseResult del(Long id) {
        return stadiumService.del(id);
    }

    /**
     * 修改场馆信息
     *
     * @param stadium
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody Stadium stadium) {
        return stadiumService.update(stadium);
    }

    /**
     * 场馆列表  分页 根据场馆名称模糊搜索
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        return stadiumService.list(pageNo, pageSize, key);
    }

    /**
     * 根据场馆id 查看详情
     *
     * @param id
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/stadiumInfo", method = RequestMethod.GET)
    public BaseResult stadiumInfo(Long id) {
        return stadiumService.stadiumInfo(id);
    }


    /**
     * 查询所有可用场馆
     *
     * @return
     */

    @RequestMapping(value = "/allStadium", method = RequestMethod.GET)
    public BaseResult allStadium() {
        return stadiumService.allStadium();
    }


}
