package com.fitness.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.fitness.api.domain.Impression;
import com.fitness.api.service.ImpressionService;
import com.fitness.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 印象-api
 * Created on 2017/7/29.
 */
@RestController
@RequestMapping("impression")
public class ImpressionController {

    @Autowired
    private ImpressionService impressionService;

    /**
     * 教练印象评价
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody JSONObject jsonObject) {
        List<Impression> impressionList = jsonObject.getJSONArray("impression").toJavaList(Impression.class);
        return impressionService.add(impressionList);
    }


}
