package com.aaa.xie.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Table(name = "ums_collect")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class Collect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    @NotNull
    private Long id;
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "status")
    private Integer status;
    @Column(name = "collect_start_time")
    private Date collectStartTime;


}