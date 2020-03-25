package com.aaa.xie.repast.utils;

import com.aaa.xie.repast.model.Order;
import com.aaa.xie.repast.model.Orders;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static com.aaa.xie.repast.staticstatus.StaticCode.TIMEPAY;

/*  @  时间    :  2020/3/24 23:16:59
 *  @  类名    :  Times
 *  @  创建人  :  Xie
 *  @  描述    : 延迟服务
 *      缺点，对服务器占用太大
 */
public class Times implements Delayed {
    private Orders orders;

    private Date orderTime;

    public Date getOrderTime() {
        return orderTime;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    private static final int expireTime = 1000;



    @Override
    public long getDelay(TimeUnit unit) {
        return orderTime.getTime() + TIMEPAY - new Date().getTime();
    }

    @Override
    public int compareTo(Delayed o) {
        return this.orderTime.getTime() - ((Order) o).getCreateTime().getTime() > 0 ? 1 : -1;
    }


}
