package com.fitness.api.impl;

import com.fitness.api.dao.ActivityDao;
import com.fitness.api.service.BannerService;
import com.fitness.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2017/8/1.
 */
@Service
public class BannerServiceImpl implements BannerService {

    //活动数据访问层
    @Autowired
    private ActivityDao activityDao;

    @Autowired

    /**
     * 首页  消息推送
     *
     * @return
     */
    @Override
    public BaseResult index() {

        return null;
    }
}
