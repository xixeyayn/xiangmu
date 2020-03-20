package com.aaa.xie.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
@Table(name = "oms_order_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    @NotNull
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "order_sn")
    private String orderSn;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_pic")
    private String productPic;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_brand")
    private String productBrand;
    @Column(name = "product_sn")
    private String productSn;
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @Column(name = "product_quantity")
    private Integer productQuantity;
    @Column(name = "product_sku_id")
    private Long productSkuId;
    @Column(name = "product_sku_code")
    private String productSkuCode;
    @Column(name = "product_category_id")
    private Long productCategoryId;
    @Column(name = "sp1")
    private String sp1;
    @Column(name = "sp2")
    private String sp2;
    @Column(name = "sp3")
    private String sp3;
    @Column(name = "promotion_name")
    private String promotionName;
    @Column(name = "promotion_amount")
    private BigDecimal promotionAmount;
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;
    @Column(name = "integration_amount")
    private BigDecimal integrationAmount;
    @Column(name = "real_amount")
    private BigDecimal realAmount;
    @Column(name = "gift_integration")
    private Integer giftIntegration;
    @Column(name = "gift_growth")
    private Integer giftGrowth;
    @Column(name = "product_attr")
    private String productAttr;
    private Product product;

}