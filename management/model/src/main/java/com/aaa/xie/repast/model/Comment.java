package com.aaa.xie.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Table(name = "pms_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    @NotNull
    private Long id;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "member_nick_name")
    private String memberNickName;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "star")
    private Integer star;
    @Column(name = "member_ip")
    private String memberIp;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "show_status")
    private Integer showStatus;
    @Column(name = "product_attribute")
    private String productAttribute;
    @Column(name = "collect_couont")
    private Integer collectCouont;
    @Column(name = "read_count")
    private Integer readCount;
    @Column(name = "pics")
    private String pics;
    @Column(name = "memner_icon")
    private String memberIcon;
    @Column(name = "replat_count")
    private Integer replayCount;
    @Column(name = "content")
    private String content;

    private List<CommentReplay> commentReplay;


}