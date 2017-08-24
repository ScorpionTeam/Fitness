package com.fitness.api.service;

import com.fitness.api.domain.Impression;
import com.fitness.result.BaseResult;

import java.util.List;

/**
 * 印象业务逻辑接口
 * Created on 2017/7/29.
 */
public interface ImpressionService {

    /**
     * 创建印象
     *
     * @param impression
     * @return
     */
    BaseResult add(List<Impression> impression);

    /**
     * 创建印象
     *
     * @param impression
     * @return
     */
    BaseResult addImpression(Impression impression);

    /**
     * 修改印象
     *
     * @param impression
     * @return
     */
    BaseResult update(Impression impression);

    /**
     * 删除印象
     *
     * @param id
     * @return
     */
    BaseResult del(Long id);

}
