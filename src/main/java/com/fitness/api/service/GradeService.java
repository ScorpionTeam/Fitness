package com.fitness.api.service;

import com.fitness.api.domain.Grade;
import com.fitness.result.BaseResult;

/**
 * Created on 2017/7/27.
 */
public interface GradeService {

    /**
     * 评分
     * @param grade
     * @return
     */
    BaseResult add(Grade grade);
}
