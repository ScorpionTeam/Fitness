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
     *
     * @param img
     * @return
     */
    Integer add(Img img);

    /**
     * 根据课程id查询图片集合
     *
     * @param thirdId
     * @return
     */
    List<Img> list(@Param(value = "thirdId") Long thirdId);

    /**
     * 创建banner图
     *
     * @param imgList
     * @return
     */
    Integer addBanner(@Param(value = "imgList") List<Img> imgList);

    /**
     * 图片列表分页
     *
     * @param rowBounds
     * @return
     */
    List<Img> pageList(RowBounds rowBounds);

    /**
     * 查询图片数量
     *
     * @return
     */
    Integer count();

    /**
     * 根据团课id删除图片
     * @param thirdId
     */
    void deleteByGroupClassId(Long thirdId);

}
