package com.fitness.api.impl;

import com.fitness.api.dao.ImpressionDao;
import com.fitness.api.domain.Impression;
import com.fitness.api.service.ImpressionService;
import com.fitness.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public BaseResult add(List<Impression> impression) {

        Integer result = impressionDao.add(impression);
        if (result > 0)
            return BaseResult.success("评价成功");
        return BaseResult.error("ADD_FAIL", "评价失败");
    }

    /**
     * 创建印象
     * @param impression
     * @return
     */
    @Override
    public BaseResult addImpression(Impression impression) {
        return null;
    }


    /**
     * 修改印象
     * @param impression
     * @return
     */
    @Override
    public BaseResult update(Impression impression) {
        return null;
    }


    /**
     * 删除印象
     * @param id
     * @return
     */
    @Override
    public BaseResult del(Long id) {
        return null;
    }


}
