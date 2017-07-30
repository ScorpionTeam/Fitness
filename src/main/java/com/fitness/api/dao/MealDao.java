package com.fitness.api.dao;

import com.fitness.api.domain.Meal;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 餐饮-数据访问层
 * Created on 2017/7/29.
 */
public interface MealDao {

    /**
     * 新增餐饮
     *
     * @param meal
     * @return
     */
    Integer add(Meal meal);

    /**
     * 餐饮列表   分页
     *
     * @param rowBounds
     * @param key
     * @return
     */
    List<Meal> list(RowBounds rowBounds, @Param(value = "key") String key);

    /**
     * 根据名称 场馆 检查餐饮
     *
     * @param mealName
     * @return
     */
    Meal validByName(@Param(value = "mealName") String mealName,
                     @Param(value = "stadiumId") Long stadiumId);


    /**
     * 餐饮列表数量
     *
     * @param key
     * @return
     */
    Integer count(@Param(value = "key") String key);

    /**
     * 根据场馆id获取营养餐列表
     *
     * @param stadiumId
     * @return
     */
    List<Meal> listByStadiumId(@Param(value = "stadiumId") Long stadiumId);
}
