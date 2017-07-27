package com.fitness.api.controller;

import com.fitness.api.domain.Grade;
import com.fitness.result.BaseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评分-api
 * Created on 2017/7/27.
 */
@RestController
@RequestMapping("grade")
public class GradeController {

    /**
     * 评分
     * @param classGrade
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseResult add(@RequestBody Grade classGrade){
        return null;
    }


}
