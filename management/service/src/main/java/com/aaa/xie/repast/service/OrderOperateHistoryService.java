package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.OrderOperateHistoryMapper;
import com.aaa.xie.repast.model.Order;
import com.aaa.xie.repast.model.OrderOperateHistory;
import com.aaa.xie.repast.staticstatus.IsEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/*  @  时间    :  2020/3/23 14:28:18
 *  @  类名    :  OrderHistoryService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class OrderOperateHistoryService extends BaseService<OrderOperateHistory> {
    @Autowired
    private OrderOperateHistoryMapper orderOperateHistoryMapper;
    @Override
    public Mapper<OrderOperateHistory> getMapper() {
        return orderOperateHistoryMapper;
    }

    public Boolean addOrderOperateHistory (OrderOperateHistory orderOperateHistory){
      return IsEmpty.isEmpty(add(orderOperateHistory)) ;
    }
}
