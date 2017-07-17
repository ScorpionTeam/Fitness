package com.fitness.api.impl;

import com.fitness.api.dao.ImgDao;
import com.fitness.api.domain.Img;
import com.fitness.api.service.ImgService;
import com.fitness.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 图片业务逻辑
 * Created on 2017/7/17.
 */
@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgDao imgDao;

    /**
     * 将图片保存到数据库
     * @param name
     * @return
     */
    @Override
    public BaseResult addImg(String name) {
        Img img = new Img();
        img.setUrl(name);
        Integer result = imgDao.add(img);
        return BaseResult.success(img);
    }
}
