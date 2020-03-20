package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Order;
import com.aaa.xie.repast.service.IRepastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*  @  时间    :  2020/3/15 17:37:12
 *  @  类名    :  OrderController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
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
    public ResultData selcetOrder(Order order){
        return iRepastService.selcetOrder(order);

    }
}
