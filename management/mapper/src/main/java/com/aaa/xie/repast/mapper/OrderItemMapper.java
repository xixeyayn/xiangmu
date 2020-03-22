package com.aaa.xie.repast.mapper;

import com.aaa.xie.repast.model.OrderItem;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface OrderItemMapper extends MySqlMapper<OrderItem>,Mapper<OrderItem> {

}