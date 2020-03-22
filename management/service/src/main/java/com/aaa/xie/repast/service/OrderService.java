package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.AddressMapper;
import com.aaa.xie.repast.mapper.OrderMapper;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.Order;
import com.aaa.xie.repast.model.OrderItem;
import com.aaa.xie.repast.staticstatus.IsEmpty;
import com.aaa.xie.repast.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static com.aaa.xie.repast.staticstatus.StaticCode.FORMAT_DATE;

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
    public Boolean addOrder(List<OrderItem> list){
        if(IsEmpty.isEmpty(list)){
            Order order= new Order();
            order.setOrderSn(UUID.randomUUID().toString());
            order.setStatus(0);
            order.setPayType(0);
            order.setCreateTime(new Date(FORMAT_DATE));
            Integer add = addGeneratedId(order);
            if(IsEmpty.isEmpty(add)){
                for (OrderItem o : list) {
                    o.setOrderId(Long.valueOf(add));
                }
                Integer integer = orderItemService.addBatch(list);
            }
        }



        return false;
    }




}
