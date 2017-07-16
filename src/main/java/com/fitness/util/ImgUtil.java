package com.fitness.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 图片上传工具类
 * Created on 2017/7/17.
 */
public class ImgUtil {

    final static Logger  LOGGER = LoggerFactory.getLogger(ImgUtil.class);


    /**
     * 文件转存
     * @param file
     * @param path
     * @return
     * @throws IOException
     */
    public static String upload(CommonsMultipartFile file,String path) throws IOException {
        existDir(path);
        String filePath = path+file.getOriginalFilename();
        File realUrl = new File(filePath);
        file.transferTo(realUrl);
        return filePath;

    }

    /**
     * 目录检查
     * @param path
     */
    private static void existDir(String path){
        File file = new File(path);
        if(!file.exists())
            if(!file.mkdir())
                LOGGER.error("创建文件目录出错--------->"+System.currentTimeMillis());
    }
}
