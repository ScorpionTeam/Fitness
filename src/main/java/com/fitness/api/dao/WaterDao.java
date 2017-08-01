package com.fitness.api.dao;

import com.fitness.api.domain.Water;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据访问层
 * Created on 2017/8/1.
 */
@Repository
public interface WaterDao {

    /**
     * 新增
     * @param water
     * @return
     */
    Integer add(Water water);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    Integer del(Long id);

    /**
     * 修改
     * @param water
     * @return
     */
    Integer update(Water water);

    /**
     * 查询数量
     * @param key
     * @return
     */
    Integer count(@Param(value = "key")String key);

    /**
     * 查询列表
     * @param rowBounds
     * @param key
     * @return
     */
    List<Water> list(RowBounds rowBounds,@Param(value = "key")String key);
}
