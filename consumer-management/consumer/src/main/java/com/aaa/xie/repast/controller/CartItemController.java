package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;

import com.aaa.xie.repast.base.ResultData;

import com.aaa.xie.repast.model.CartItem;

import com.aaa.xie.repast.service.IRepastService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/*  @  时间    :  2020/3/22 10:25:06
 *  @  类名    :  CartItemController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */

@RestController

@Api(value = "购物车信息", tags = "购物车接口(提供购物车有关操作)")
public class CartItemController extends BaseController {
    @Autowired
    private IRepastService iRepastService;
    @ApiOperation(value = "查询", notes = "查询我的购物车")
    @PostMapping("/selectCartItem")
    public ResultData selectCartItem(@RequestBody CartItem cartItem){
          return iRepastService.selectCartItem(cartItem);
    }
    @ApiOperation(value = "增加", notes = "增加我的购物车")
    @PostMapping("/addCartItem")
    public ResultData addCartItem(@RequestBody CartItem cartItems){
          return iRepastService.addCartItem(cartItems);
    }
    @ApiOperation(value = "删除", notes = "删除我的购物车")
    @PostMapping("/deleteCartItem")
    public ResultData deleteCartItem(@RequestBody List<CartItem> cartItems){
       return deleteCartItem(cartItems);
    }
    @ApiOperation(value = "更改", notes = "更改我的购物车")
    @PostMapping("/updateCartItem")
    public ResultData updateCartItem(@RequestBody CartItem cartItem){
            return iRepastService.updateCartItem(cartItem);
    }
}
