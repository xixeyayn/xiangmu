package com.aaa.xie.repast.util;

import com.aaa.xie.repast.model.CouponHistory;
import com.aaa.xie.repast.service.CouponHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.Task;

/*  @  时间    :  2020/3/15 15:45:42
 *  @  类名    :  TimeUtil
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@EnableScheduling
@Configuration
public class TimeUtil {
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
