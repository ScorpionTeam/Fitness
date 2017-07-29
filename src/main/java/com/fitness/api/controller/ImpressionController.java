package com.fitness.api.controller;

import com.fitness.api.domain.Impression;
import com.fitness.result.BaseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 印象-api
 * Created on 2017/7/29.
 */
@RestController
@RequestMapping("impression")
public class ImpressionController {

    /**
     * 教练印象评价
     *
     * @param impression
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody Impression impression) {
        return null;
    }

    /**
     * 根据教练id查询印象集合
     *
     * @param coachId
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResult list(Long coachId) {
        return null;
    }

}
