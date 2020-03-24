package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.MemberStatisticsInfoMapper;
import com.aaa.xie.repast.model.MemberStatisticsInfo;
import com.aaa.xie.repast.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/*  @  时间    :  2020/3/20 01:31:18
 *  @  类名    :  MemberStatisticsInfoService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class MemberStatisticsInfoService extends BaseService<MemberStatisticsInfo> {
    @Autowired
    private MemberStatisticsInfoMapper memberStatisticsInfoMapper;
    @Override
    public Mapper<MemberStatisticsInfo> getMapper() {
        return memberStatisticsInfoMapper;
    }
}
