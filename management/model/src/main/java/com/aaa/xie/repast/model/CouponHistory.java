package com.aaa.xie.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Table(name = "sms_coupon_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class CouponHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    @NotNull
    private Long id;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "coupon_id")
    private Long couponId;
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "coupon_code")
    private String couponCode;
    @Column(name = "member_nickname")
    private String memberNickname;
    @Column(name = "get_type")
    private Integer getType;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "use_status")
    private Integer useStatus;
    @Column(name = "use_time")
    private Date useTime;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "order_sn")
    private String orderSn;

    private Coupon coupon;

}