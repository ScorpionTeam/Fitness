package com.fitness.api.dao;

import com.fitness.api.domain.Stadium;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 场馆数据访问层
 * Created on 2017/7/3.
 */
@Repository
public interface StadiumDao {

    /**
     * 创建场馆
     * @param stadium
     * @return
     */
    Integer add(Stadium stadium);

    /**
     * 修改场馆
     * @param stadium
     * @return
     */
    Integer update(Stadium stadium);

    /**
     * 根据场馆id 删除场馆
     * @param id
     * @return
     */
    Integer del(Long id);

    /**
     * 模糊查询场馆数量
     * @param key
     * @return
     */
    Integer count(@Param(value = "key") String key);

    /**
     * 模糊查询场馆列表  分页
     * @param rowBounds
     * @param key
     * @return
     */
    List<Stadium> list(RowBounds rowBounds, @Param(value = "key") String key);

    /**
     * 根据场馆id  查询场馆详情
     * @param id
     * @return
     */
    Stadium stadiumInfo(Long id);

    /**
     * 查询所有可用场馆列表
     * @return
     */
    List<Stadium> allStadium();
}
