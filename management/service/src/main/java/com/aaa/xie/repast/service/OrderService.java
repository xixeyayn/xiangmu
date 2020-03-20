package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.AddressMapper;
import com.aaa.xie.repast.mapper.OrderMapper;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/*  @  时间    :  2020/3/15 17:27:50
 *  @  类名    :  OrderService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class OrderService extends BaseService<Order> {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemService orderItemService;

    @Override
    public Mapper<Order> getMapper() {
        return orderMapper;
    }

    public List<Order> selectOrder(Order order){
        List<Order> orders = queryList(order);
        for (Order o : orders) {
            o.setOrderItem(orderItemService.selectOrderItemOrProduct(o));
        }
//        List<Order> orders1 = orderMapper.selectOrderByMemberId(order);
        return orders;
        //


    }


}
