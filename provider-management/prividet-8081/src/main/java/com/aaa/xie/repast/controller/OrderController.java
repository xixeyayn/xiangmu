package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Order;
import com.aaa.xie.repast.model.OrderItem;
import com.aaa.xie.repast.model.Orders;
import com.aaa.xie.repast.service.OrderService;
import com.aaa.xie.repast.staticstatus.IsEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/*  @  时间    :  2020/3/15 17:29:13
 *  @  类名    :  OrderController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
public class OrderController extends CommonController<Order> {
    @Autowired
    private OrderService orderService;
    @Override
    public BaseService<Order> getBaseService() {
        return orderService;
    }
    /*
     * @Author Xie
     * @Description 
     *       对订单的查询
     * @Date 17:35 2020/3/15
     * @Param [order]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selcetOrder")
    public ResultData selcetOrder(Order order){
        List<Order> orders = orderService.selectOrder(order);
        if(IsEmpty.isEmpty(orders)) {
            return operationSuccess(orders);
        }
            return operationFailed();


    }
    @PostMapping("/addOrder")
    public ResultData addOrder(Orders tmodel, @RequestParam("couponId")Long couponId){
        return null;

    }

}
