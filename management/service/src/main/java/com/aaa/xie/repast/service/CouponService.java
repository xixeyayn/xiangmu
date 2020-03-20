package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.mapper.CouponMapper;
import com.aaa.xie.repast.model.Coupon;
import com.aaa.xie.repast.model.CouponProductCategoryRelation;
import com.aaa.xie.repast.model.CouponProductRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.List;

import static com.aaa.xie.repast.staticstatus.StaticCode.FORMAT_DATE;

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
/*
 * @Author Xie
 * @Description 
 *       待测试
 * @Date 22:07 2020/3/16
 * @Param []
 * @return com.aaa.xie.repast.model.Coupon
 **/
    public List<Coupon> selectCouponByTime(Coupon coupon){
        coupon.setEndTime(new Date());
        Sqls sqls=Sqls.custom();
        sqls.andGreaterThanOrEqualTo("end_time",new Date(FORMAT_DATE));
        sqls.andLessThanOrEqualTo("start_time",new Date(FORMAT_DATE));
        List coupon1 = queryListByFields(sqls, null, null);
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
