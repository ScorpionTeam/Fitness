package com.fitness.api.service;

import com.fitness.api.domain.Img;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

import java.util.List;

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

    /**
     * 新增轮播图
     * @param imgList
     * @return
     */
    BaseResult addBanner(List<Img> imgList);


    /**
     * 图片列表分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult pageList(Integer pageNo,Integer pageSize);

}
