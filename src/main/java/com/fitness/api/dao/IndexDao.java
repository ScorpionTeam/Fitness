package com.fitness.api.dao;

import com.fitness.api.domain.Index;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/7/1.
 */
@Repository
public interface IndexDao {

    List<Index> list(RowBounds rowBounds);

    int count();
}
