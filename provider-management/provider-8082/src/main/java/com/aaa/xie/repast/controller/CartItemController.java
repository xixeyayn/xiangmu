package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.dynamic.annotation.TDS;
import com.aaa.xie.repast.model.CartItem;
import com.aaa.xie.repast.service.CartItemService;
import com.aaa.xie.repast.staticstatus.IsEmpty;
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
@TDS
@RestController
public class CartItemController extends CommonController<CartItem> {
    @Autowired
    private CartItemService cartItemService;
    @Override
    public BaseService<CartItem> getBaseService() {
        return cartItemService;
    }
    @PostMapping("/selectCartItem")
    public ResultData selectCartItem(@RequestBody Map cartItem){
            if(IsEmpty.isEmpty(cartItem)){
               return selcet(cartItem);
            }
            return super.operationFailed();
    }
    @PostMapping("/addCartItem")
    public ResultData addCartItem(@RequestBody CartItem cartItems){
           if(cartItemService.addCartItem(cartItems)){
               return super.operationSuccess();
           }
        return super.operationFailed();
    }
    @PostMapping("/deleteCartItem")
    public ResultData deleteCartItem(@RequestBody List<CartItem> cartItems){
       if(cartItemService.deleteCartItem(cartItems)){
           return super.operationSuccess();
       }
       return super.operationFailed();
    }
    @PostMapping("/updateCartItem")
    public ResultData updateCartItem(@RequestBody Map cartItem){
            return update(cartItem);
    }
}
