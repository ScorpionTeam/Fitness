package com.fitness.api.dao;

import com.fitness.api.domain.Img;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 图片数据访问层
 * Created on 2017/7/3.
 */
@Repository
public interface ImgDao {

    /**
     * 新增图片数据
     * @param img
     * @return
     */
    Integer add(Img img);

    /**
     *
     * @param id
     * @return
     */
    List<Img> list(Long id);

}
