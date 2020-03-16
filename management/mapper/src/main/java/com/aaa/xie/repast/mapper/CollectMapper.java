package com.aaa.xie.repast.mapper;

import com.aaa.xie.repast.model.Collect;
import tk.mybatis.mapper.common.Mapper;

public interface CollectMapper extends Mapper<Collect> {
    int deleteByPrimaryKey(Long id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}