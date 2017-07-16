package com.fitness.api.impl;

import com.fitness.api.dao.IndexDao;
import com.fitness.api.domain.Index;
import com.fitness.api.service.IndexService;
import com.fitness.result.page.PageResult;
import com.fitness.result.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2017/7/1.
 */
@Service
public class IndexServiceImpl implements IndexService, PageService {

    @Autowired
    private IndexDao indexDao;

    @Override
    public PageResult list(Integer pageNo, Integer pageSize) {
        int count = indexDao.count();
        if (count <= 0)
            return new PageResult(null, 0, pageNo, pageSize);
        List<Index> list = indexDao.list(rowBounds(pageNo, pageSize));
        return new PageResult(list, count, pageNo, pageSize);
    }
}
