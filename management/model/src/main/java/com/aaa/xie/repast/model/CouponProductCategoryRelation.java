package com.aaa.xie.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "sms_coupon_product_category_relation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class CouponProductCategoryRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    @NotNull
    private Long id;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "coupon_id")
    private Long couponId;
    @Column(name = "product_category_id")
    private Long productCategoryId;
    @Column(name = "product_categroy_name")
    private String productCategoryName;
    @Column(name = "parent_categroy_name")
    private String parentCategoryName;


}