package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.AddressMapper;
import com.aaa.xie.repast.mapper.OrderMapper;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/*  @  时间    :  2020/3/15 17:27:50
 *  @  类名    :  OrderService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
public class OrderService extends BaseService<Order> {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Mapper<Order> getMapper() {
        return orderMapper;
    }


}
