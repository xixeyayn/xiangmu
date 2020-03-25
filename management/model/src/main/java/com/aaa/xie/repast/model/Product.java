package com.aaa.xie.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Table(name = "pms_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    @NotNull
    private Long id;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "brand_id")
    private Long brandId;
    @Column(name = "product_category_id")
    private Long productCategoryId;
    @Column(name = "product_attribute_category_id")
    private Long productAttributeCategoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "pic")
    private String pic;
    @Column(name = "product_sn")
    private String productSn;
    @Column(name = "member_id")
    private Integer deleteStatus;
    @Column(name = "member_id")
    private Integer publishStatus;
    @Column(name = "member_id")
    private Integer newStatus;
    @Column(name = "member_id")
    private Integer recommandStatus;
    @Column(name = "member_id")
    private Integer sort;
    @Column(name = "member_id")
    private Integer sale;
    @Column(name = "member_id")
    private BigDecimal price;
    @Column(name = "member_id")
    private BigDecimal promotionPrice;
    @Column(name = "member_id")
    private Integer giftPoint;
    @Column(name = "member_id")
    private String subTitle;
    @Column(name = "member_id")
    private BigDecimal originalPrice;
    @Column(name = "member_id")
    private Integer stock;
    @Column(name = "member_id")
    private Integer lowStock;
    @Column(name = "member_id")
    private String unit;
    @Column(name = "member_id")
    private BigDecimal weight;
    @Column(name = "member_id")
    private String serviceIds;
    @Column(name = "member_id")
    private String keywords;
    @Column(name = "member_id")
    private String note;
    @Column(name = "member_id")
    private Long albumId;
    @Column(name = "member_id")
    private String detailTitle;
    @Column(name = "member_id")
    private Date promotionStartTime;
    @Column(name = "member_id")
    private Date promotionEndTime;
    @Column(name = "member_id")
    private Integer promotionPerLimit;
    @Column(name = "member_id")
    private Integer promotionType;
    @Column(name = "member_id")
    private String brandName;
    @Column(name = "member_id")
    private String productCategoryName;
    @Column(name = "member_id")
    private Byte currency;


}