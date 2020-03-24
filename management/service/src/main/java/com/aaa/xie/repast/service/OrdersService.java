package com.aaa.xie.repast.service;

import com.aaa.xie.repast.mapper.OrderMapper;
import com.aaa.xie.repast.model.*;
import com.aaa.xie.repast.redis.RedisService;
import com.aaa.xie.repast.staticstatus.IsEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.aaa.xie.repast.staticstatus.StaticCode.FORMAT_DATE;

/*  @  时间    :  2020/3/24 13:17:59
 *  @  类名    :  Orders
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class OrdersService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private OrderOperateHistoryService orderOperateHistoryService;
    @Autowired
    private CouponHistoryService couponHistoryService;

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberStatisticsInfoService memberStatisticsInfoService;
    @Autowired
    private ProductService productService;
    //    @Autowired
    private RedisService redisService;



/*
 * @Author Xie
 * @Description 
 *       对外卖的订单
 * @Date 13:33 2020/3/24
 * @Param * @param null: 
 * @return * @return: null
 **/

    public  Integer  addOrder (Orders orders){
        List<OrderItem> orderItem = orders.getOrderItem();
        Order order = orders.getOrder();
        CouponHistory coupon = orders.getCouponHistory();
        try {
            synchronized(OrderService.class){
                if(IsEmpty.isEmpty(orderItem)&&IsEmpty.isEmpty(coupon)&&IsEmpty.isEmpty(order)){
                    List<CouponHistory> couponHistories = couponHistoryService.selcetCouponHistoty(coupon);
                    coupon=couponHistories.get(0);
                    coupon.setUseStatus(1);
                    String s = UUID.randomUUID().toString();
                    order.setOrderSn(s);
                    order.setNote(s);
                    order.setStatus(0);
                    order.setPayType(0);
                    order.setSourceType(1);
                    order.setCouponAmount(coupon.getCoupon().getAmount());
                    order.setCreateTime(new Date(FORMAT_DATE));
                    Integer add = orderService.addGeneratedId(order);
                    if(IsEmpty.isEmpty(add)){
                        for (OrderItem o : orderItem) {
                            o.setOrderId(Long.valueOf(add));
                        }
                        if(IsEmpty.isEmpty(orderItemService.addBatch(orderItem))){
                            CouponHistory coupon1 = new CouponHistory();
                            coupon1 = coupon1.setCouponId(coupon.getCouponId());
                            if(coupon1.getUseStatus()==0&&coupon1.getCoupon().getAmount()==order.getCouponAmount()){
                                coupon.setOrderId(Long.valueOf(add));
                                coupon.setUseTime(new Date(FORMAT_DATE));
                                if(couponHistoryService.updateCouponHistory(coupon)){
                                    OrderOperateHistory orderOperateHistory = new OrderOperateHistory();
                                    orderOperateHistory.setCreateTime(new Date(FORMAT_DATE));
                                    orderOperateHistory.setOperateMan("普通用户");
                                    orderOperateHistory.setOrderStatus(0);
                                    orderOperateHistory.setOrderId(order.getId());
                                    orderOperateHistory.setShopId(order.getShopId());
                                    if(IsEmpty.isEmpty(orderOperateHistoryService.addOrderOperateHistory(orderOperateHistory))){
                                        redisService.set(order.getMemberId().toString(),order.getMemberId(),"NX","PX",900);
                                        if(payOrder(null,orders)){
                                            return 0;
                                        }else {
                                            return 1;
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
            throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 2;
    }
    /*
     * @Author Xie
     * @Description 
     *       查询订单相关信息
     * @Date 14:11 2020/3/24
     * @Param [order]
     * @return com.aaa.xie.repast.model.Orders
     **/
    public Orders selectOrderZt(Order order){
        Orders orders = new Orders();
        order = orderService.queryOne(order);
        if(IsEmpty.isEmpty(order)){
            orders.setOrder(order);
            List<OrderItem> orderItems = orderItemService.selectOrderItemOrProduct(order);
            if(IsEmpty.isEmpty(orderItems)){
                orders.setOrderItem(orderItems);
                CouponHistory couponHistory = new CouponHistory();
                couponHistory.setOrderId(order.getId());
                couponHistoryService.selcetCouponHistoty(couponHistory);
                orders.setCouponHistory(couponHistory);
                return orders;
            }
        }
        return null;
    }
/*
 * @Author Xie
 * @Description 
 *       支付
 * @Date 14:11 2020/3/24
 * @Param [order, orders]
 * @return java.lang.Boolean
 **/
    public Boolean payOrder(Order order,Orders orders){
        try {
            synchronized (OrdersService.class){
                Date date = new Date(FORMAT_DATE);
                if(!IsEmpty.isEmpty(orders)){
                    orders= selectOrderZt(order);
                    if(null==orders) throw new Exception();
                }
                order=orders.getOrder();
                BigDecimal payAmount = order.getPayAmount();

                String string = redisService.getString(order.getMemberId().toString());
                if(IsEmpty.isEmpty(string)){
                    //调用微信支付
                    if(true){
                        order.setPayType(2);
                        order.setReceiveTime(date);
                        order.setModifyTime(date);
                        if(order.getFlag()==0){
                            order.setStatus(1);
                        }else if(order.getFlag()==2){
                            order.setStatus(2);
                        }
                        if(IsEmpty.isEmpty(orderService.update(order))){
                            Member member = new Member();
                            member.setId(order.getMemberId());
                            member = memberService.queryOne(member);
                            member.setIntegration(member.getIntegration()+order.getIntegration());
                             if(!IsEmpty.isEmpty(memberService.update(member))){
                                 throw new Exception();
                             }
                        }
                        //放开锁
                        redisService.delOne(order.getMemberId().toString());
                        return true;
                    }else {
                        if(order.getStatus()==4){
                            order.setModifyTime(date);
                            CouponHistory couponHistory = orders.getCouponHistory();
                            couponHistory.setUseStatus(0);
                            couponHistory.setUseTime(null);
                            if(couponHistoryService.updateCouponHistory(couponHistory)){
                                if(IsEmpty.isEmpty(orderService.update(order))){
                                    return false;
                                }
                            }
                        }

                    }
                }
            }
            throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
        }
return null;
    }
}
