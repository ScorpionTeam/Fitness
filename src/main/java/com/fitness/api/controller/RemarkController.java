package com.fitness.api.controller;

import com.fitness.annotations.OathAnnotation;
import com.fitness.api.domain.Remark;
import com.fitness.api.service.RemarkService;
import com.fitness.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by THINK on 2017/7/8.
 */
@RestController
@RequestMapping(value="remark")
public class RemarkController {

    @Autowired
    private RemarkService remarkService;

    /**
     * 新增评分
     * @param remark
     * @return
     */
    @OathAnnotation
    @RequestMapping(value="insertRemark",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult insertRemark(@RequestBody Remark remark){
        return remarkService.insertRemark(remark);
    }

    /**
     * 获取某位教练的综合评分
     * @param coachId
     * @return
     */
    @OathAnnotation
    @RequestMapping(value="getCoachScoreById",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult getCoachScoreById(Long coachId){
        return remarkService.getCoachScoreById(coachId);
    }

    /**
     * 获取某位教练的评论次数最多的前三条印象
     * @param coachId
     * @return
     */
    @OathAnnotation
    @RequestMapping(value="getImpression",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult getImpression(Long coachId){
        return remarkService.getImpression(coachId);
    }
}
