package com.fitness.api.controller;

import com.fitness.api.domain.PrivateClass;
import com.fitness.api.service.PrivateClassService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 私教课-api
 * Created on 2017/7/1.
 */
@RestController
@RequestMapping("privateClass")
public class PrivateClassController {

    @Autowired
    private PrivateClassService privateClassService;

    /**
     * 新增课程
     *
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody PrivateClass privateClass) {
        return privateClassService.add(privateClass);
    }

    /**
     * 根据教练id 查询课程列表
     *
     * @param pageNo
     * @param pageSize
     * @param coachId
     * @return
     */

    @RequestMapping(value = "/listByCoachId", method = RequestMethod.GET)
    public PageResult listByCoachId(Integer pageNo, Integer pageSize, Long coachId) {
        return privateClassService.listByCoachId(pageNo, pageSize, coachId);
    }

    /**
     * 修改课程
     *
     * @param privateClass
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody PrivateClass privateClass) {
        return privateClassService.update(privateClass);
    }

    /**
     * 我的课程   根据会员id 查询课程信息
     *
     * @param memberId
     * @return
     */

    @RequestMapping(value = "/myClass", method = RequestMethod.GET)
    public PageResult myClass(Integer pageNo, Integer pageSize, Long memberId) {
        return privateClassService.myClass(pageNo, pageSize, memberId);
    }

    /**
     * 删除课程
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResult del(Long id) {
        return privateClassService.del(id);
    }
}
