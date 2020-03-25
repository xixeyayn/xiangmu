package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Order;
import com.aaa.xie.repast.model.Orders;
import com.aaa.xie.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*  @  时间    :  2020/3/15 17:37:12
 *  @  类名    :  OrderController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
@Api(value = "订单信息", tags = "订单信息接口(提供订单有关操作)")
public class OrderController extends BaseController {
    @Autowired
    private IRepastService iRepastService;
    /*
     * @Author Xie
     * @Description 
     *       根据id查询订单
     * @Date 17:39 2020/3/15
     * @Param [order]
     * @return com.aaa.xie.repast.base.ResultData
     **/

    @PostMapping("/selcetOrder")
    @ApiOperation(value = "查询", notes = "查询个人订单")
    public ResultData selcetOrder(@RequestBody Order order){
        return iRepastService.selcetOrder(order);

    }

    @PostMapping("/payOrder")
    @ApiOperation(value = "支付", notes = "对已下订单进行支付")
    public ResultData patOrder(@RequestBody Order order){
        return iRepastService.patOrder(order);
    }

    @PostMapping("/addOrder")
    @ApiOperation(value = "增加", notes = "下单")
    public ResultData addOrder(@RequestBody Orders orders){
        return iRepastService.addOrder(orders);
    }
}
