package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.AddressMapper;
import com.aaa.xie.repast.mapper.CollectMapper;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/*  @  时间    :  2020/3/16 18:56:23
 *  @  类名    :  CollectService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class CollectService extends BaseService<Collect> {
    @Autowired
    private CollectMapper collectMapper;

    @Override
    public Mapper<Collect> getMapper() {
        return collectMapper;
    }
}
