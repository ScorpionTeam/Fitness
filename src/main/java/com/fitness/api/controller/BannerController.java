package com.fitness.api.controller;

import com.fitness.result.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页  - 推送信息
 * Created on 2017/8/1.
 */
@RestController
@RequestMapping("banner")
public class BannerController {

    /**
     * 首页推送信息
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public BaseResult index() {
        return null;
    }
}
