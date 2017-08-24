package com.fitness.api.controller;

import com.fitness.api.service.GroupClassService;
import com.fitness.api.service.PrivateClassService;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日程
 * Created on 2017/8/23.
 */

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private PrivateClassService privateClassService;

    @Autowired
    private GroupClassService groupClassService;

    /**
     * 根据当天日期 查询私教课日程
     *
     * @param pageNo
     * @param pageSize
     * @param date
     * @return
     */
    @RequestMapping(value = "/privateClassInfo", method = RequestMethod.GET)
    public PageResult privateClassInfo(Integer pageNo, Integer pageSize, String date) {
        return null;
    }

    /**
     * 根据当天日期 查询团课日程
     * @param pageNo
     * @param pageSize
     * @param date
     * @return
     */
    @RequestMapping(value = "/groupClassInfo", method = RequestMethod.GET)
    public PageResult groupClassInfo(Integer pageNo, Integer pageSize, String date) {
        return null;
    }


}
