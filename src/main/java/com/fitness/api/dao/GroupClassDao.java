package com.fitness.api.dao;

import com.fitness.api.domain.GroupClass;
import org.springframework.stereotype.Repository;


/**
 *
 * 团课  -数据访问层
 * Created on 2017/7/23.
 */
@Repository
public interface GroupClassDao {

    /**
     * 创建团课
     * @param groupClass
     * @return
     */
    Integer add(GroupClass groupClass);

    /**
     * 根据团课id 删除
     * @param id
     * @return
     */
    Integer del(Long id);

    /**
     * 团课详情
     * @param id
     * @return
     */
    GroupClass classInfo(Long id);

    /**
     * 修改团课
     * @param groupClass
     * @return
     */
    Integer update(GroupClass groupClass);


}
