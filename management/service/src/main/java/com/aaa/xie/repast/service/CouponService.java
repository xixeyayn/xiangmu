package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.mapper.CouponMapper;
import com.aaa.xie.repast.model.Coupon;
import com.aaa.xie.repast.model.CouponProductCategoryRelation;
import com.aaa.xie.repast.model.CouponProductRelation;
import com.aaa.xie.repast.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.List;

import static com.aaa.xie.repast.staticstatus.StaticCode.*;

/*  @  时间    :  2020/3/15 13:20:09
 *  @  类名    :  CouponService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class CouponService extends BaseService<Coupon> {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private CouponProductRelationService couponProductRelationService;
    @Autowired
    private CouponProductCategoryRelationService couponProductCategoryRelationService;
    @Autowired
    private RedisService redisService;
/*
 * @Author Xie
 * @Description 
 *       只能查通用的
 * @Date 22:07 2020/3/16
 * @Param []
 * @return com.aaa.xie.repast.model.Coupon
 **/
    public List<Coupon> selectCouponByTime(Coupon coupon){
        List<Coupon> coupon1=redisService.getList(COUPON);
        if(coupon1==null){
            coupon.setEndTime(new Date());
            List<Coupon> coupons = queryList(coupon);
            redisService.set(COUPON,coupon,"NX","PX",DAYS);
            return coupons;
        }
        return coupon1;


    }
    /*
     * @Author Xie
     * @Description 
     *       查询单个优惠券
     * @Date 6:01 2020/3/21
     * @Param [coupon]
     * @return com.aaa.xie.repast.model.Coupon
     **/
    public Coupon selectCoupon(Coupon coupon){
        coupon=queryOne(coupon);
        CouponProductRelation couponProductRelation = new CouponProductRelation();
        CouponProductCategoryRelation couponProductCategoryRelation = new CouponProductCategoryRelation();
        coupon.setCouponProductCategoryRelation(couponProductCategoryRelationService.selectCouponProductCategoryRelation(couponProductCategoryRelation.setCouponId(coupon.getId())));
        coupon.setCouponProductRelation(couponProductRelationService.selectCouponProductRelation(couponProductRelation.setCouponId(coupon.getId())));
        return coupon;
    }

}
