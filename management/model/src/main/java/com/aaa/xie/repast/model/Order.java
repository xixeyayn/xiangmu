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
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "group_promorion_id")
    private Long groupPromotionId;
    @Column(name = "coupon_id")
    private Long couponId;
    @Column(name = "order_sn")
    private String orderSn;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "member_username")
    private String memberUsername;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "pay_amount")
    private BigDecimal payAmount;
    @Column(name = "freight_amount")
    private BigDecimal freightAmount;
    @Column(name = "promotion_amount")
    private BigDecimal promotionAmount;
    @Column(name = "intergration_amount")
    private BigDecimal integrationAmount;
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;
    @Column(name = "discountAmount")
    private BigDecimal discountAmount;
    @Column(name = "pay_type")
    private Integer payType;
    @Column(name = "source_type")
    private Integer sourceType;
    @Column(name = "status")
    private Integer status;
    @Column(name = "order_type")
    private Integer orderType;
    @Column(name = "deliveryCompany")
    private String deliveryCompany;
    @Column(name = "deliver_sn")
    private String deliverySn;
    @Column(name = "auto_confir_day")
    private Integer autoConfirmDay;
    @Column(name = "intergtation")
    private Integer integration;
    @Column(name = "growth")
    private Integer growth;
    @Column(name = "promotion_info")
    private String promotionInfo;
    @Column(name = "bill_type")
    private Integer billType;
    @Column(name = "bill_header")
    private String billHeader;
    @Column(name = "bill_content")
    private String billContent;
    @Column(name = "bill_receiver_phone")
    private String billReceiverPhone;
    @Column(name = "bill_receive_email")
    private String billReceiverEmail;
    @Column(name = "receive_name")
    private String receiverName;
    @Column(name = "receiver_post_phone")
    private String receiverPhone;
    @Column(name = "receiver_post_code")
    private String receiverPostCode;
    @Column(name = "receiver_province")
    private String receiverProvince;
    @Column(name = "receiver_city")
    private String receiverCity;
    @Column(name = "receiver_region")
    private String receiverRegion;
    @Column(name = "receiver_detail_address")
    private String receiverDetailAddress;
    @Column(name = "note")
    private String note;
    @Column(name = "confirm_status")
    private Integer confirmStatus;
    @Column(name = "delete_status")
    private Integer deleteStatus;
    @Column(name = "use_intergretion")
    private Integer useIntegration;
    @Column(name = "payment_time")
    private Date paymentTime;
    @Column(name = "delivery_time")
    private Date deliveryTime;
    @Column(name = "receive_time")
    private Date receiveTime;
    @Column(name = "comment_time")
    private Date commentTime;
    @Column(name = "modify_time")
    private Date modifyTime;
    @Column(name = "flag")
    private Integer flag;

}