package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.CartItemMapper;

import com.aaa.xie.repast.model.CartItem;
import com.aaa.xie.repast.model.Product;
import com.aaa.xie.repast.staticstatus.IsEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

import static com.aaa.xie.repast.staticstatus.StaticCode.*;

/*  @  时间    :  2020/3/22 09:25:31
 *  @  类名    :  CartItemService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class CartItemService extends BaseService<CartItem> {
    @Autowired
    private CartItemMapper cartItemMapper;
    @Autowired
    private ProductService productService;

    @Override
    public Mapper<CartItem> getMapper() {
        return cartItemMapper;
    }

    /*
     * @Author Xie
     * @Description
     *       增加购物车
     * @Date 9:59 2020/3/22
     * @Param [cartItem]
     * @return java.lang.Boolean
     **/
    public Boolean addCartItem (CartItem cartItem){
        if(IsEmpty.isEmpty(cartItem)){
            if(IsEmpty.isEmpty(cartItem.getMemberId())&&IsEmpty.isEmpty(cartItem.getProductId())){
                cartItem.setCreateDate(new Date(FORMAT_DATE));
                cartItem.setDeleteStatus(ZERO);
                Integer add = add(cartItem);
                if(IsEmpty.isEmpty(add)){
                    Product product = new Product();
                    product = productService.selectOneProduct(product.setId(cartItem.getProductId()));
                    product.setLowStock(product.getLowStock()-cartItem.getQuantity());
                    //走定时
                   return IsEmpty.isEmpty(productService.update(product));
                }

            }
        }
            return false;
    }

    /*
     * @Author Xie
     * @Description 
     *       删除购物车
     * @Date 10:09 2020/3/22
     * @Param [cartItem]
     * @return java.lang.Boolean
     **/
        public Boolean deleteCartItem(List cartItems){
        if(IsEmpty.isEmpty(cartItems)){
                CartItem cartItem = new CartItem();
                cartItem.setModifyDate(new Date(FORMAT_DATE));
                cartItem.setDeleteStatus(ONE);
                //方法未更新
                Integer update = updateBatch(cartItem,cartItems,null);
                return IsEmpty.isEmpty(update);
        }
        return false;
    }

}
