package com.fitness.result.page;

import org.apache.ibatis.session.RowBounds;

/**
 * Created on 2017/7/1.
 */
public interface PageService {
    default RowBounds rowBounds(Integer pageNo, Integer pageSize) {
        if (null == pageNo)
            return null;
        return new RowBounds((pageNo - 1) * pageSize, pageSize == null ? 10 : pageSize);
    }
}
