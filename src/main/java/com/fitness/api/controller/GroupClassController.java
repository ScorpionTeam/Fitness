package com.fitness.api.controller;

import com.fitness.api.domain.GroupClass;
import com.fitness.result.BaseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 团课
 * Created on 2017/7/23.
 */
@RestController
@RequestMapping("groupClass")
public class GroupClassController {


    /**
     * 创建团课
     * @param groupClass
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody GroupClass groupClass) {
        return null;
    }

    /**
     * 修改团课
     * @param groupClass
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public BaseResult update(@RequestBody GroupClass groupClass){
        return null;
    }

    /**
     * 根据id删除团课
     * @param id
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public BaseResult del(Long id){
        return null;
    }

    /**
     * 团课详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/classInfo",method = RequestMethod.GET)
    public BaseResult classInfo(Long id){
        return null;
    }

    /**
     * 报名
     * @param memberId
     * @param classId
     * @return
     */
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public BaseResult apply(Long memberId,Long classId){
        return null;
    }
}
