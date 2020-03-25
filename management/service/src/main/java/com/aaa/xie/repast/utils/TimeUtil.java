package com.aaa.xie.repast.utils;

import com.aaa.xie.repast.service.CouponHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/*  @  时间    :  2020/3/15 15:45:42
 *  @  类名    :  TimeUtil
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@EnableScheduling
@Configuration
public class TimeUtil {
    public final static long ONE_Minute =  60 * 1000;
    @Autowired
    private CouponHistoryService couponHistoryService;
    @Scheduled(cron="0 0 23 * * ?")
    public void taskCouponHistory(){
        Boolean aBoolean = couponHistoryService.updateCouponHistoryTime();
        if(aBoolean==false){
            couponHistoryService.updateCouponHistoryTime();
        }
    }
}
