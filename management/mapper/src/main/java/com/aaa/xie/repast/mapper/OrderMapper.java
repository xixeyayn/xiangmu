package com.aaa.xie.repast.mapper;

import com.aaa.xie.repast.model.Order;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    List<Order> selectOrderByMemberId(Order order);
}