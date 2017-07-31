package com.fitness.api.controller;

import com.fitness.api.domain.Img;
import com.fitness.api.service.ImgService;
import com.fitness.constant.Constant;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.util.ImgUtil;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

/**
 * 图片上传接口
 * Created on 2017/7/17.
 */
@RestController
@RequestMapping("img")
public class ImgController {

    @Autowired
    private ImgService imgService;

    /**
     * 上传图片
     *
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public BaseResult upload(@RequestParam CommonsMultipartFile file) throws IOException {
        String url = ImgUtil.upload(file, Constant.PATH);
        if (!StringUtils.isNullOrEmpty(url))
            return imgService.addImg(url);
        return BaseResult.error("FAIL", "图片上传失败");
    }

    /**
     * 查询图片集合
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResult list(Long id) {

        return null;
    }

    /**
     * 图片列表分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.GET)
    public PageResult pageList(Integer pageNo, Integer pageSize) {
        return imgService.pageList(pageNo, pageSize);
    }



}
