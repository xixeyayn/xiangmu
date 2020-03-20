package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.OrderItemMapper;
import com.aaa.xie.repast.mapper.OrderMapper;
import com.aaa.xie.repast.mapper.ProductMapper;
import com.aaa.xie.repast.model.Order;
import com.aaa.xie.repast.model.OrderItem;
import com.aaa.xie.repast.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/*  @  时间    :  2020/3/21 04:10:45
 *  @  类名    :  OrderItemService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class OrderItemService extends BaseService<OrderItem> {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductService productService;

    @Override
    public Mapper<OrderItem> getMapper() {
        return orderItemMapper;
    }

    public List<OrderItem> selectOrderItemOrProduct(Order order){
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(order.getId());
        List<OrderItem> orderItems = queryList(orderItem);
        for (OrderItem o:orderItems) {
            Product product = new Product();
            o.setProduct(productService.selectOneProduct( product.setId(o.getProductId())));
        }
        return orderItems;
    }
}
