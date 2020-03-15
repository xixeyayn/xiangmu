package com.aaa.xie.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
@Table(name = "oms_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    @NotNull
    private Long id;
    @Column(name = "order_sn")
    private Long memberId;
    @Column(name = "order_sn")
    private Long shopId;
    @Column(name = "order_sn")
    private Long groupPromotionId;
    @Column(name = "order_sn")
    private Long couponId;
    @Column(name = "order_sn")
    private String orderSn;
    @Column(name = "order_sn")
    private Date createTime;
    @Column(name = "order_sn")
    private String memberUsername;
    @Column(name = "order_sn")
    private BigDecimal totalAmount;
    @Column(name = "order_sn")
    private BigDecimal payAmount;
    @Column(name = "order_sn")
    private BigDecimal freightAmount;
    @Column(name = "order_sn")
    private BigDecimal promotionAmount;
    @Column(name = "order_sn")
    private BigDecimal integrationAmount;
    @Column(name = "order_sn")
    private BigDecimal couponAmount;
    @Column(name = "order_sn")
    private BigDecimal discountAmount;
    @Column(name = "order_sn")
    private Integer payType;
    @Column(name = "order_sn")
    private Integer sourceType;
    @Column(name = "order_sn")
    private Integer status;
    @Column(name = "order_sn")
    private Integer orderType;
    @Column(name = "order_sn")
    private String deliveryCompany;
    @Column(name = "order_sn")
    private String deliverySn;
    @Column(name = "order_sn")
    private Integer autoConfirmDay;
    @Column(name = "order_sn")
    private Integer integration;
    @Column(name = "order_sn")
    private Integer growth;
    @Column(name = "order_sn")
    private String promotionInfo;
    @Column(name = "order_sn")
    private Integer billType;
    @Column(name = "order_sn")
    private String billHeader;
    @Column(name = "order_sn")
    private String billContent;
    @Column(name = "order_sn")
    private String billReceiverPhone;
    @Column(name = "order_sn")
    private String billReceiverEmail;
    @Column(name = "order_sn")
    private String receiverName;
    @Column(name = "order_sn")
    private String receiverPhone;
    @Column(name = "order_sn")
    private String receiverPostCode;
    @Column(name = "order_sn")
    private String receiverProvince;
    @Column(name = "order_sn")
    private String receiverCity;
    @Column(name = "order_sn")
    private String receiverRegion;
    @Column(name = "order_sn")
    private String receiverDetailAddress;
    @Column(name = "order_sn")
    private String note;
    @Column(name = "order_sn")
    private Integer confirmStatus;
    @Column(name = "order_sn")
    private Integer deleteStatus;
    @Column(name = "order_sn")
    private Integer useIntegration;
    @Column(name = "order_sn")
    private Date paymentTime;
    @Column(name = "order_sn")
    private Date deliveryTime;
    @Column(name = "order_sn")
    private Date receiveTime;
    @Column(name = "order_sn")
    private Date commentTime;
    @Column(name = "order_sn")
    private Date modifyTime;
    @Column(name = "order_sn")
    private Integer flag;

}