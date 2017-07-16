package com.fitness.api.controller;

import com.fitness.annotations.OathAnnotation;
import com.fitness.api.domain.CoachJob;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工作经历-api
 * Created on 2017/7/2.
 */
@RestController
@RequestMapping("coachJob")
public class CoachJobController {

    /**
     * 创建工作经历
     * @param coachJob
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody CoachJob coachJob) {
        return null;
    }

    /**
     * 修改工作经历
     * @param coachJob
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody CoachJob coachJob) {
        return null;
    }

    /**
     * 根据工作经历id 删除
     * @param id
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResult del(Long id) {
        return null;
    }

    /**
     * 根据工作经历描述头  查询工作经历  分页
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        return null;

    }
}
