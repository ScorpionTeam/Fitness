package com.fitness.api.impl;

import com.fitness.api.dao.ImgDao;
import com.fitness.api.domain.Img;
import com.fitness.api.service.ImgService;
import com.fitness.constant.Constant;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图片业务逻辑
 * Created on 2017/7/17.
 */
@Service
public class ImgServiceImpl implements ImgService, PageService {

    @Autowired
    private ImgDao imgDao;

    /**
     * 将图片保存到数据库
     *
     * @param name
     * @return
     */
    @Override
    public BaseResult addImg(String name) {
        Img img = new Img();
        img.setUrl(name);
        Integer result = imgDao.add(img);
        if (result > 0)
            return BaseResult.success(img);
        return BaseResult.error("ADD_FAIL", "保存图片失败");
    }

    /**
     * 新增 轮播图
     *
     * @param imgList
     * @return
     */
    @Override
    public BaseResult addBanner(List<Img> imgList) {
        return null;
    }


    /**
     * 图片列表分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult pageList(Integer pageNo, Integer pageSize) {
        //查询图片数量
        Integer count = imgDao.count();
        if (count <= 0)
            return new PageResult(null, 0);

        //查询图片集合
        List<Img> list = imgDao.pageList(rowBounds(pageNo, pageSize));
        if (null != list && list.size() > 0)
            list.forEach(item -> {
                item.setUrl(Constant.URL_KEEPER + item.getUrl());
            });
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 新增图片
     *
     * @param img
     * @return
     */
    @Override
    public BaseResult add(Img img) {
        Integer result = imgDao.add(img);
        if (result > 0)
            return BaseResult.success("新增图片成功");
        return BaseResult.error("ADD_FAIL", "新增图片失败");
    }
}
