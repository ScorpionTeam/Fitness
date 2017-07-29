package com.fitness.api.controller;

import com.fitness.api.domain.Coach;
import com.fitness.api.service.CoachService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 教练-api
 * Created on 2017/7/1.
 */
@RestController
@RequestMapping("coach")
public class CoachController {

    @Autowired
    private CoachService coachService;

    /**
     * 新增教练
     *
     * @param coach
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody Coach coach) {
        return coachService.add(coach);
    }


    /**
     * 教练列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        return coachService.list(pageNo, pageSize, key);
    }

    /**
     * 教练详情
     *
     * @param id
     * @return
     */

    @RequestMapping(value = "/coachInfo", method = RequestMethod.GET)
    public BaseResult coachInfo(Long id) {
        return coachService.coachInfo(id);
    }

    /**
     * 修改教练信息
     *
     * @param coach
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody Coach coach) {
        return coachService.update(coach);
    }

    /**
     * 根据教练id  删除
     *
     * @param id
     * @return
     */

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResult del(Long id) {
        return coachService.del(id);
    }

    /**
     * 根据场馆id获取教练列表
     *
     * @param stadiumId
     * @return
     */

    @RequestMapping(value = "/coachListByStadiumId", method = RequestMethod.GET)
    public BaseResult coachListByStadiumId(Long stadiumId) {
        return coachService.coachListByStadiumId(stadiumId);
    }

}
