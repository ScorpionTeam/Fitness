package com.fitness.api.service;

import com.fitness.result.page.PageResult;

/**
 * Created on 2017/7/1.
 */
public interface IndexService {

    PageResult list(Integer pageNo,Integer pageSize);

}
