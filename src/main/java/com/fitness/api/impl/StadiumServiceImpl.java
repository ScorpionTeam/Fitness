package com.fitness.api.impl;

import com.fitness.api.dao.StadiumDao;
import com.fitness.api.domain.Stadium;
import com.fitness.api.service.StadiumService;
import com.fitness.constant.Constant;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 场馆业务逻辑
 * Created on 2017/7/3.
 */
@Service
public class StadiumServiceImpl implements StadiumService, PageService {

    @Autowired
    private StadiumDao stadiumDao;


    @Override
    public BaseResult add(Stadium stadium) {

        Integer result = stadiumDao.add(stadium);

        if (result <= 0)
            return BaseResult.error("ADD_FAIL", "创建场馆失败");

        return BaseResult.success("新增场馆成功");
    }

    /**
     * 根据场馆id  删除场馆
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {

        Integer result = stadiumDao.del(id);

        if (result <= 0)
            return BaseResult.error("DEL_FAIL", "删除场馆失败");

        return BaseResult.success("删除场馆成功");
    }

    /**
     * 根据场馆名称模糊搜索
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

        Integer count = stadiumDao.count(key);

        if (count <= 0)
            return new PageResult(null, 0);

        List<Stadium> list = stadiumDao.list(rowBounds(pageNo, pageSize), key);

        list.forEach(item -> {
            item.setImgPath(Constant.URL_KEEPER + item.getImgPath());
        });

        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 修改场馆信息
     *
     * @param stadium
     * @return
     */
    @Override
    public BaseResult update(Stadium stadium) {

        Integer result = stadiumDao.update(stadium);

        if (result <= 0)
            return BaseResult.error("UPDATE_FAIL", "修改场馆失败");

        return BaseResult.success("修改场馆成功");
    }

    /**
     * 根据场馆id  查看场馆详情
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult stadiumInfo(Long id) {

        Stadium stadium = stadiumDao.stadiumInfo(id);

        if (null == stadium)
            return BaseResult.nonSuchResult();

        stadium.setImgPath(Constant.URL_KEEPER + stadium.getImgPath());

        return BaseResult.success(stadium);
    }

    /**
     * 查询所有可用场馆列表
     *
     * @return
     */
    @Override
    public BaseResult allStadium() {
        List<Stadium> list = stadiumDao.allStadium();
        return BaseResult.success(list);
    }
}
