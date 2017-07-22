package com.fitness.api.controller;

import com.fitness.annotations.OathAnnotation;
import com.fitness.api.domain.Activity;
import com.fitness.api.service.ActivityService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 活动-api
 * Created on 2017/7/1.
 */
@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 创建活动
     *
     * @param activity
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody Activity activity) {
        return activityService.add(activity);
    }

    /**
     * 修改活动信息
     *
     * @param activity
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody Activity activity) {
        return activityService.update(activity);
    }

    /**
     * 删除活动
     *
     * @param id
     * @return
     */

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResult del(Long id) {
        return activityService.del(id);
    }

    /**
     * 所有活动列表  分页  关键字查询
     * 根据场馆id  查询
     *
     * @param pageNo
     * @param pageSize
     * @return
     */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize) {
        return activityService.list(pageNo, pageSize);
    }

    /**
     * 根据会员id查询我的活动
     *
     * @param pageNo
     * @param pageSize
     * @param memberId
     * @return
     */

    @RequestMapping(value = "/myActivity", method = RequestMethod.GET)
    public PageResult myActivity(Integer pageNo, Integer pageSize, Long memberId) {
        return activityService.myActivity(pageNo, pageSize, memberId);
    }

    /**
     * 根据场馆id 查询最新活动
     *
     * @param pageNo
     * @param pageSize
     * @param stadiumId
     * @return
     */

    @RequestMapping(value = "/newActivity", method = RequestMethod.GET)
    public PageResult newActivity(Integer pageNo, Integer pageSize, Long stadiumId) {
        return activityService.newActivity(pageNo, pageSize, stadiumId);
    }

    /**
     * 根据活动id查询活动详情
     *
     * @param id
     * @return
     */

    @RequestMapping(value = "/activityInfo", method = RequestMethod.GET)
    public BaseResult activityInfo(Long id) {
        return activityService.activityInfo(id);
    }

    /**
     * 根据场馆id 查询往期活动   分页
     *
     * @param pageNo
     * @param pageSize
     * @param stadiumId
     * @return
     */

    @RequestMapping(value = "/pastActivity", method = RequestMethod.GET)
    public PageResult pastActivity(Integer pageNo, Integer pageSize, Long stadiumId) {
        return activityService.pastActivity(pageNo, pageSize, stadiumId);
    }

    /**
     * 根据最新活动id 查询最新活动
     * @param id
     * @return
     */

    @RequestMapping(value = "/visitNewest",method = RequestMethod.GET)
    public BaseResult visitNewest(Long id){
        return null;
    }


    /**
     * 添加活动
     * @param memberId
     * @param activityId
     * @return
     */
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public BaseResult apply(Long memberId,Long activityId){
        return null;
    }


}
