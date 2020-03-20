package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.MemberLevelMapper;
import com.aaa.xie.repast.mapper.MemberMapper;
import com.aaa.xie.repast.mapper.OrderMapper;
import com.aaa.xie.repast.model.MemberLevel;
import com.aaa.xie.repast.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/*  @  时间    :  2020/3/20 01:13:57
 *  @  类名    :  MenberLevelService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class MemberLevelService extends BaseService<MemberLevel> {
    @Autowired
    private MemberLevelMapper memberLevelMapper;

    @Override
    public Mapper<MemberLevel> getMapper() {
        return memberLevelMapper;
    }
}
