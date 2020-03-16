package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.AddressMapper;
import com.aaa.xie.repast.mapper.CouponHistoryMapper;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.Coupon;
import com.aaa.xie.repast.model.CouponHistory;
import com.aaa.xie.repast.staticstatus.StaticCode;
import com.aaa.xie.repast.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

import static com.aaa.xie.repast.staticstatus.StaticCode.DAYS;
import static com.aaa.xie.repast.staticstatus.StaticCode.FORMAT_DATE;

/*  @  时间    :  2020/3/15 13:19:47
 *  @  类名    :  CouponHistoryService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class CouponHistoryService extends BaseService<CouponHistory> {
    @Autowired
    private CouponHistoryMapper couponHistoryMapper;
    @Autowired
    private CouponService couponService;

    @Override
    public Mapper<CouponHistory> getMapper() {
        return couponHistoryMapper;
    }

    /*
     * @Author Xie
     * @Description 
     *       这里是领取方法，未写领取时的判断
     * @Date 13:49 2020/3/15
     * @Param [couponHistory]
     * @return java.util.List<com.aaa.xie.repast.model.CouponHistory>
     **/
    public Boolean addCouponHistory(CouponHistory couponHistory){

        couponHistory.setCreateTime(new Date(FORMAT_DATE));
        Coupon coupon = new Coupon();
        coupon.setId(couponHistory.getCouponId());
        coupon = couponService.queryOne(coupon);
        coupon.setReceiveCount(coupon.getReceiveCount()+1);
        couponService.add(coupon);
        //领取方式的判断
        Integer add = add(couponHistory);
        if(null!=add&&add>0){
            return true;
        }
        return false;
    }
    /*
     * @Author Xie
     * @Description 
     *       使用优惠券的操作
     * @Date 13:52 2020/3/15
     * @Param [couponHistory]
     * @return java.lang.Boolean
     **/
    public Boolean updateCouponHistory(CouponHistory couponHistory){
        //使用时的判断
        couponHistory.setUseStatus(2);
        Coupon coupon = new Coupon();
        coupon.setId(couponHistory.getCouponId());
        coupon = couponService.queryOne(coupon);
        coupon.setUseCount(coupon.getUseCount()+1);
        couponService.add(coupon);
        Integer update = update(couponHistory);
        if(null!=update&&update>0){
            return true;
        }
        return false;
    }
    /*
     * @Author Xie
     * @Description 
     *       定时任务
     * @Date 13:53 2020/3/15
     * @Param []
     * @return java.lang.Boolean
     **/
    public Boolean updateCouponHistoryTime(){
        CouponHistory couponHistory = new CouponHistory();
        couponHistory.setUseStatus(0);
        List<CouponHistory> couponHistories = queryList(couponHistory);
        if(null!=couponHistories){
            for (CouponHistory c: couponHistories) {
                Integer time1=c.getUseTime().getSeconds();
                int seconds = new Date().getSeconds();
                if(seconds<time1){
                   c.setUseStatus(3);
                   update(c);
                }

            }
            return true;
        }

        return false;
    }


}
