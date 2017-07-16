package com.fitness.api.controller;

import com.fitness.constant.Constant;
import com.fitness.result.BaseResult;
import com.fitness.util.ImgUtil;
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


    /**
     * 上传图片
     *
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public BaseResult upload(@RequestParam CommonsMultipartFile file) throws IOException {
        String url = ImgUtil.upload(file, Constant.PATH);
        return BaseResult.success(url);
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

}
