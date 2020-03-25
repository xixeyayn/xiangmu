package com.aaa.xie.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/*  @  时间    :  2020/3/22 17:38:25
 *  @  类名    :  Tmodel
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */

@Data
public class Orders implements Serializable {
    private Order order;
    private CouponHistory couponHistory;
    private List<OrderItem> orderItem;
}
