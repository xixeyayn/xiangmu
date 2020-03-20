package com.aaa.xie.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
@Table(name = "ums_member_level")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class MemberLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    @NotNull
    private Long id;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "name")
    private String name;
    @Column(name = "growth_point")
    private Integer growthPoint;
    @Column(name = "defalt_status")
    private Integer defaultStatus;
    @Column(name = "free_treigh_point")
    private BigDecimal freeFreightPoint;
    @Column(name = "comment_growth_point")
    private Integer commentGrowthPoint;
    @Column(name = "priviledge_free_freight")
    private Integer priviledgeFreeFreight;
    @Column(name = "priviledge_sign_in")
    private Integer priviledgeSignIn;
    @Column(name = "priviledge_comment")
    private Integer priviledgeComment;
    @Column(name = "priviledge_promotion")
    private Integer priviledgePromotion;
    @Column(name = "priviledge_menber_price")
    private Integer priviledgeMemberPrice;
    @Column(name = "priviledge_birthday")
    private Integer priviledgeBirthday;
    @Column(name = "note")
    private String note;

}