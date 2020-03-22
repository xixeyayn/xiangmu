package com.aaa.xie.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
@Table(name = "ums_member_statistics_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class MemberStatisticsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    @NotNull
    private Long id;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "consume_amount")
    private BigDecimal consumeAmount;
    @Column(name = "order_count")
    private Integer orderCount;
    @Column(name = "coupon_count")
    private Integer couponCount;
    @Column(name = "comment_count")
    private Integer commentCount;
    @Column(name = "return_order_count")
    private Integer returnOrderCount;
    @Column(name = "login_count")
    private Integer loginCount;
    @Column(name = "attend_count")
    private Integer attendCount;
    @Column(name = "fans_count")
    private Integer fansCount;
    @Column(name = "collect_product_count")
    private Integer collectProductCount;
    @Column(name = "collect_subject_count")
    private Integer collectSubjectCount;
    @Column(name = "collect_topic_count")
    private Integer collectTopicCount;
    @Column(name = "collect_comment_count")
    private Integer collectCommentCount;
    @Column(name = "invite_friend_count")
    private Integer inviteFriendCount;
    @Column(name = "recent_order_time")
    private Date recentOrderTime;


}