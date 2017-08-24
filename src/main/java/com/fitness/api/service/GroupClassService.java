package com.fitness.api.service;

import com.fitness.api.domain.GroupClass;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;

import java.security.acl.Group;
import java.util.List;

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
     * @param classId
     * @return
     */
    BaseResult apply(Long memberId,Long classId);

    /**
     * 根据场馆id 查询团课列表
     * @param stadiumId
     * @return
     */
    PageResult classListByStadium(Integer pageNo,Integer pageSize,Long stadiumId,String date);

    /**
     * 团课列表  分页
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    PageResult list(Integer pageNo,Integer pageSize,String key);

    /**
     * 根据课程id查询团课详情
     * @param id
     * @return
     */
    BaseResult classInfoByClassId(Long id);

    /**
     * 根据场馆id查询往期图片
     * @param stadiumId
     * @return
     */
    BaseResult pastClass(Long stadiumId);

    /**
     * 根据日期、会员查询 团课日程信息
     * @param pageNo
     * @param pageSize
     * @param date
     * @param memberId
     * @return
     */
    PageResult scheduleGroupClass(Integer pageNo,Integer pageSize,String date,Long memberId);

}
