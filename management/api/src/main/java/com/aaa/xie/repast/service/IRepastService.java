package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.*;
import com.aaa.xie.repast.page.PageInfos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:16
 * @Description
 *      springcloud2.x之后，在feign中只能出现一次
 *      value的值非常重要:
 *          这个value的值，就取决于是否可以调用到provider中的值
 *              !!!! value的值指向的就是provider项目中application.properties文件中所配置的spring.application.name !!!!
 *              !!!! api中所写的接口，一定要和provider的Controller中的方法一模一样 !!!!
 **/
@FeignClient(value = "memberinfo-interface")
//@FeignClient(value = "memberinfo-interface", fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param [member]
     * @date 2020/3/10
     * @return java.lang.Boolean
     * @throws 
    **/
    @PostMapping("/doLogin")
    Boolean doLogin(@RequestBody Member member);

    /**
     * @author Seven Lee
     * @description
     *      登录日志保存
     * @param [loginLog]
     * @date 2020/3/11
     * @return java.lang.Boolean
     * @throws
    **/
    @PostMapping("/addlog")
    ResultData saveLog(@RequestBody Map map);
/*
 * @Author Xie
 * @Description 
 *       修改个人信息
 * @Date 16:38 2020/3/13
 * @Param [member]
 * @return java.lang.Boolean
 **/
    @PostMapping("/updateMember")
    ResultData updateMember(@RequestBody Member member);
    /*
     * @Author Xie
     * @Description 
     *       增加地址
     * @Date 19:03 2020/3/14
     * @Param [address]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/addAddress")
    ResultData addAddress(@RequestBody Address address);
    /*
     * @Author Xie
     * @Description 
     *       修改地址
     * @Date 21:11 2020/3/14
     * @Param [address]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/updateAddress")
    ResultData updateAddress(@RequestBody Address address);
    /*
     * @Author Xie
     * @Description 
     *  删除地址
     * @Date 21:11 2020/3/14
     * @Param [address]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/deleteAddress")
    ResultData deleteAddress(@RequestBody Address address);
    /*
     * @Author Xie
     * @Description 
     *       查询地址
     * @Date 21:13 2020/3/14
     * @Param [address]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selcetAddress")
    ResultData selcetAddress(@RequestBody Address address);
    /*
     * @Author Xie
     * @Description 
     *       删除所有地址
     * @Date 21:13 2020/3/14
     * @Param [memberId]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/deleteAllAddress")
    ResultData deleteAllAddress(@RequestBody List id);

    /*
     * @Author Xie
     * @Description 
     *       更改状态码
     * @Date 23:45 2020/3/14
     * @Param [address]
     * @return java.lang.Boolean
     **/
    @PostMapping("/updateAddressStatus")
     ResultData updateAddresStatus(@RequestBody Address address);

    /*
     * @Author Xie
     * @Description 
     *        查询所有的正在发行的优惠券
     * @Date 14:00 2020/3/15
     * @Param * @param null: 
     * @return * @return: null
     **/
    @PostMapping("/selectCoupon")
    ResultData selectCoupon();
    /*
     * @Author Xie
     * @Description 
     *       查询我的优惠券
     * @Date 14:04 2020/3/15
     * @Param [map]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selcetCouponHistory")
    ResultData selcetCouponHistoty(@RequestBody CouponHistory couponHistory);
    /*
     * @Author Xie
     * @Description 
     *       增加我的优惠券
     * @Date 14:07 2020/3/15
     * @Param [couponHistory]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/addCouponHistory")
    ResultData addCouponHistoty(@RequestBody CouponHistory couponHistory);
    /*
     * @Author Xie
     * @Description 
     *       查询个人信息
     * @Date 17:11 2020/3/15
     * @Param [token]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectMember")
    ResultData selcetMember(@RequestBody Member member);
    /*
     * @Author Xie
     * @Description 
     *       根据id查询订单
     * @Date 17:36 2020/3/15
     * @Param [order]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selcetOrder")
    ResultData selcetOrder(@RequestBody Order order);
    /*
     * @Author Xie
     * @Description 
     *       查找评价及评价回复
     * @Date 20:15 2020/3/15
     * @Param [pageInfos]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selcetCommentById")
    ResultData selcetCommentById(@RequestBody PageInfos pageInfos);
    /*
     * @Author Xie
     * @Description 
     *       查询我的收藏地址
     * @Date 19:18 2020/3/16
     * @Param [collect]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectCollectByMemberId")
     ResultData selectCollectByMemberId(@RequestBody Collect collect);
    /*
     * @Author Xie
     * @Description 
     *       取消我的收藏
     * @Date 19:20 2020/3/16
     * @Param [collect]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/updateCollectByMemberId")
     ResultData updateCollectByMemberId(@RequestBody Collect collect);
    /*
     * @Author Xie
     * @Description 
     *       查询会员等级
     * @Date 1:36 2020/3/20
     * @Param []
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectMemberLevel")
     ResultData selectMemberLevel();
    /*
     * @Author Xie
     * @Description 
     *       查询个人详细信息
     * @Date 1:39 2020/3/20
     * @Param [memberStatisticsInfo]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectmemberStatisticsInfoByMemberId")
     ResultData selectmemberStatisticsInfoByMemberId(@RequestBody MemberStatisticsInfo memberStatisticsInfo);
    @PostMapping("/addCollect")
     ResultData addCollect(@RequestBody Collect collect);
    @PostMapping("/addComment")
     ResultData addComment(@RequestBody Comment comment);
    @PostMapping("/selectProductFullReduction")
     ResultData selectProductFullReduction(@RequestBody ProductFullReduction productFullReduction);
    @PostMapping("/selectProductLadder")
     ResultData selectProductLadder(@RequestBody ProductLadder productLadder);
    @PostMapping("/payOrder")
    public ResultData patOrder(@RequestBody Order order);
    @PostMapping("/addOrder")
    public ResultData addOrder(@RequestBody Orders orders);
    @PostMapping("/selectCartItem")
    public ResultData selectCartItem(@RequestBody CartItem cartItem);
    @PostMapping("/addCartItem")
    public ResultData addCartItem(@RequestBody CartItem cartItems);
    @PostMapping("/deleteCartItem")
    public ResultData deleteCartItem(@RequestBody List<CartItem> cartItems);
    @PostMapping("/updateCartItem")
    public ResultData updateCartItem(@RequestBody CartItem cartItem);
}
