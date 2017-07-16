package com.fitness.api.controller;

import com.fitness.api.service.IndexService;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/7/1.
 */
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public PageResult index(Integer pageNo, Integer pageSize) {
        return indexService.list(pageNo, pageSize);
    }
}
