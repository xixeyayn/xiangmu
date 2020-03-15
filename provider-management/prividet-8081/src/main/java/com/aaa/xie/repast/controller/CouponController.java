package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Coupon;
import com.aaa.xie.repast.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.HashMap;

/*  @  时间    :  2020/3/15 13:26:51
 *  @  类名    :  CouponController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
public class CouponController extends CommonController<Coupon> {
    @Autowired
    private CouponService couponService;
    @Override
    public BaseService<Coupon> getBaseService() {
        return couponService;
    }
    /*
     * @Author Xie
     * @Description 
     *       查询所有的正在发行的优惠券
     * @Date 13:59 2020/3/15
     * @Param []
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectCoupon")
    public ResultData selectCoupon(){
        return selcet(new HashMap());
    }
    
}
