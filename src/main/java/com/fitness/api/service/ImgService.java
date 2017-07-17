package com.fitness.api.service;

import com.fitness.result.BaseResult;

/**
 * Created on 2017/7/17.
 */
public interface ImgService {

    /**
     * 新增图片数据
     * @param name
     * @return
     */
    BaseResult addImg(String name);
}
