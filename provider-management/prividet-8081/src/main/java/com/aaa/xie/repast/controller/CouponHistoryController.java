package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.Coupon;
import com.aaa.xie.repast.model.CouponHistory;
import com.aaa.xie.repast.service.AddressService;
import com.aaa.xie.repast.service.CouponHistoryService;
import com.aaa.xie.repast.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*  @  时间    :  2020/3/15 13:27:10
 *  @  类名    :  CouponHistoryController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
public class CouponHistoryController extends CommonController<CouponHistory> {
    @Autowired
    private CouponHistoryService couponHistoryService;

    @Override
    public BaseService<CouponHistory> getBaseService() {
        return couponHistoryService;
    }
    /*
     * @Author Xie
     * @Description 
     *       查询优惠券
     * @Date 17:20 2020/3/15
     * @Param [couponHistory]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selcetCouponHistory")
    public ResultData selcetCouponHistoty(CouponHistory couponHistory){
        List<CouponHistory> couponHistories = couponHistoryService.selcetCouponHistoty(couponHistory);
        if(null==couponHistories.get(0)){
            return operationFailed();
        }
        return operationSuccess(couponHistories);
    }
    /*
     * @Author Xie
     * @Description 
     *       添加优惠券
     * @Date 17:20 2020/3/15
     * @Param [couponHistory]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/addCouponHistory")
    public ResultData addCouponHistoty(CouponHistory couponHistory){
        Boolean aBoolean = couponHistoryService.addCouponHistory(couponHistory);
        if(aBoolean==true){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }

    }

}
