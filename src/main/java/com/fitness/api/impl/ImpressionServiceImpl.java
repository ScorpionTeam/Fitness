package com.fitness.api.impl;

import com.fitness.api.dao.ImpressionDao;
import com.fitness.api.domain.Impression;
import com.fitness.api.service.ImpressionService;
import com.fitness.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 印象业务逻辑层
 * Created on 2017/7/29.
 */
@Service
public class ImpressionServiceImpl implements ImpressionService {

    @Autowired
    private ImpressionDao impressionDao;

    /**
     * 创建印象
     *
     * @param impression
     * @return
     */
    @Override
    public BaseResult add(Impression impression) {

        Integer result = impressionDao.add(impression);
        if (result > 0)
            return BaseResult.success("评价成功");
        return BaseResult.error("ADD_FAIL", "评价失败");
    }

    /**
     * 根据教练id查询印象列表
     *
     * @param coachId
     * @return
     */
    @Override
    public BaseResult list(Long coachId) {
        List<Impression> list = impressionDao.list(coachId);
        if (null == list && list.size() <= 0)
            list = new ArrayList<Impression>();
        return BaseResult.success(list);

    }
}
