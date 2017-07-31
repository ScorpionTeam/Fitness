package com.fitness.api.dao;

import com.fitness.api.domain.Img;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
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

    /**
     * 创建banner图
     * @param imgList
     * @return
     */
    Integer addBanner(List<Img> imgList);

    /**
     * 图片列表分页
     * @param rowBounds
     * @return
     */
    List<Img> pageList(RowBounds rowBounds);

    /**
     * 查询图片数量
     * @return
     */
    Integer count();

}
