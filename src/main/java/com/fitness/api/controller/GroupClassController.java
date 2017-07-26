package com.fitness.api.controller;

import com.fitness.api.domain.GroupClass;
import com.fitness.api.service.GroupClassService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 团课
 * Created on 2017/7/23.
 */
@RestController
@RequestMapping("groupClass")
public class GroupClassController {


    @Autowired
    private GroupClassService groupClassService;

    /**
     * 创建团课
     *
     * @param groupClass
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody GroupClass groupClass) {
        return groupClassService.add(groupClass);
    }

    /**
     * 修改团课
     *
     * @param groupClass
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody GroupClass groupClass) {
        return groupClassService.update(groupClass);
    }

    /**
     * 根据id删除团课
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResult del(Long id) {
        return groupClassService.del(id);
    }

    /**
     * 团课详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/classInfo", method = RequestMethod.GET)
    public BaseResult classInfo(Long id) {
        return groupClassService.classInfo(id);
    }

    /**
     * 报名
     *
     * @param memberId
     * @param classId
     * @return
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public BaseResult apply(Long memberId, Long classId) {
        return groupClassService.apply(memberId, classId);
    }


    /**
     * 根据场馆查询团课列表
     * @param stadiumId
     * @return
     */
    @RequestMapping(value = "/classListByStadium",method = RequestMethod.GET)
    public PageResult classListByStadium(Integer pageNo,Integer pageSize,Long stadiumId,String date){
        return groupClassService.classListByStadium(pageNo,pageSize,stadiumId,date);
    }

    /**
     * 团课列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageResult list(Integer pageNo,Integer pageSize,String key){
        return groupClassService.list(pageNo,pageSize,key);
    }

}
