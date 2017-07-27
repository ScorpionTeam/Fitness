package com.fitness.api.impl;

import com.fitness.api.dao.ClassGradeDao;
import com.fitness.api.dao.CoachDao;
import com.fitness.api.dao.CoachJobDao;
import com.fitness.api.domain.ClassGrade;
import com.fitness.api.domain.Coach;
import com.fitness.api.domain.CoachJob;
import com.fitness.api.service.CoachService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 教练业务逻辑层
 * Created on 2017/7/12.
 */
@Service
public class CoachServiceImpl implements CoachService, PageService {

    @Autowired
    private CoachDao coachDao;

    @Autowired
    private CoachJobDao coachJobDao;

    @Autowired
    private ClassGradeDao classGradeDao;

    /**
     * 新增教练
     *
     * @param coach
     * @return
     */
    @Override
    public BaseResult add(Coach coach) {
        Integer result = coachDao.add(coach);
        if (result <= 0)
            return BaseResult.error("ADD_FAIL", "新增教练失败");
        return BaseResult.success("新增教练成功");
    }

    /**
     * 根据关键字查询教练  分页
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        if (!StringUtils.isNullOrEmpty(key))
            key = "%" + key + "%";
        Integer count = coachDao.count(key);
        if (count <= 0)
            return new PageResult(null, 0);
        List<Coach> list = coachDao.list(rowBounds(pageNo, pageSize), key);
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 根据教练Id 查看详情
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult coachInfo(Long id) {

        //根据教练id查询基本信息
        Coach coach = coachDao.coachInfo(id);
        if (null == coach)
            return BaseResult.nonSuchResult();

        //根据教练id查询工作经历集合
//        List<CoachJob> coachJobList = coachJobDao.coachJobList(coach.getId());
//        if (null == coachJobList || coachJobList.size() <= 0)
//            coach.setJobList(new ArrayList<>());
//
//        coach.setJobList(coachJobList);

        //查询评分
        ClassGrade classGrade = new ClassGrade();
        classGrade = classGradeDao.getScoreByCoachId(id);
        coach.setClassGrade(classGrade);
        return BaseResult.success(coach);
    }


    /**
     * 修改教练信息
     *
     * @param coach
     * @return
     */
    @Override
    public BaseResult update(Coach coach) {
        Integer result = coachDao.update(coach);
        if (result > 0)
            return BaseResult.success("修改教练信息成功");
        return BaseResult.error("UPDATE_FAIL", "修改失败");
    }

    /**
     * 根据教练id删除教练信息
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        Integer result = coachDao.del(id);
        if (result > 0)
            return BaseResult.success("删除教练信息成功");

        return BaseResult.error("DELETE_FAIL", "删除失败");
    }

    /**
     * 根据场馆id查询教练集合
     *
     * @param stadiumId
     * @return
     */
    @Override
    public BaseResult coachListByStadiumId(Long stadiumId) {
        List<Coach> list = coachDao.coachListByStadiumId(stadiumId);
        if (null == list || list.size() <= 0)
            return BaseResult.nonSuchResult();
        return BaseResult.success(list);
    }
}
