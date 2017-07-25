package com.fitness.api.service;

import com.fitness.api.domain.GroupClass;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

import java.security.acl.Group;

/**
 * 团课 -业务逻辑接口
 * Created on 2017/7/23.
 */
public interface GroupClassService {

    /**
     * 创建团课
     * @param groupClass
     * @return
     */
    BaseResult add(GroupClass groupClass);

    /**
     * 修改团课
     * @param groupClass
     * @return
     */
    BaseResult update(GroupClass groupClass);

    /**
     * 根据团课id  删除团课
     * @param id
     * @return
     */
    BaseResult del(Long id);

    /**
     * 团课详情
     * @param id
     * @return
     */
    BaseResult classInfo(Long id);

    /**
     * 报名 团课
     * @param memberId
     * @param id
     * @return
     */
    BaseResult apply(Long memberId,Long id);

    /**
     * 根据场馆id 查询团课列表
     * @param stadiumId
     * @return
     */
    PageResult classListByStadium(Integer pageNo,Integer pageSize,Long stadiumId,String date);

}
