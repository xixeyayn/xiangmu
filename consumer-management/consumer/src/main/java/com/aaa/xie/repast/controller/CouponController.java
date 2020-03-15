package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Coupon;
import com.aaa.xie.repast.model.CouponHistory;
import com.aaa.xie.repast.service.IRepastService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/*  @  时间    :  2020/3/15 14:00:38
 *  @  类名    :  CouponController
 *  @  创建人  :  Xie
 *  @  描述    :
 *  集合查询所有优惠劵及自己的优惠券
 */
public class CouponController extends BaseController {
    @Autowired
    private IRepastService repastService;

    /*
     * @Author Xie
     * @Description 
     *       查询所有的正在发行的优惠券
     * @Date 14:02 2020/3/15
     * @Param * @param null: 
     * @return * @return: null
     **/
    @PostMapping("/selectCoupon")
    public ResultData selectCoupon(){
        return repastService.selectCoupon();
    }
    /*
     * @Author Xie
     * @Description 
     *       查询我的优惠券
     * @Date 14:07 2020/3/15
     * @Param [couponHistory]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selcetCouponHistory")
    public ResultData selcetCouponHistoty(CouponHistory couponHistory){
        return repastService.selcetCouponHistoty(couponHistory);
    }
    /*
     * @Author Xie
     * @Description 
     *       增加我的优惠券
     * @Date 14:09 2020/3/15
     * @Param [couponHistory]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/addCouponHistory")
    public ResultData addCouponHistoty(CouponHistory couponHistory){
        return repastService.addCouponHistoty(couponHistory);
    }
}
