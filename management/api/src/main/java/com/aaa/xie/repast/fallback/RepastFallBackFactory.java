package com.aaa.xie.repast.fallback;

import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.CouponHistory;
import com.aaa.xie.repast.model.Member;
import com.aaa.xie.repast.model.Order;
import com.aaa.xie.repast.page.PageInfos;
import com.aaa.xie.repast.service.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:17
 * @Description
 **/
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {
            @Override
            public Boolean doLogin(Member member) {
                System.out.println("熔断登录方法！");
                return null;
            }

            @Override
            public ResultData saveLog(Map map) {
                System.out.println("熔断日志方法！");
                return null;
            }
            @Override
            public ResultData updateMember(Member member){
                System.out.println("更改个人信息失败");
                return null;
            }

            @Override
            public ResultData addAddress( Address address) {
                System.out.println("增加地址成功");
                return null;
            }

            @Override
            public ResultData updateAddress(Address address) {
                return null;
            }

            @Override
            public ResultData deleteAddress(Address address) {
                return null;
            }

            @Override
            public ResultData selcetAddress(Address address) {
                return null;
            }

            @Override
            public ResultData deleteAllAddress(Integer[] id) {
                return null;
            }

            @Override
            public ResultData updateAddresStatus(Address address) {
                return null;
            }

            @Override
            public ResultData selectCoupon() {
                return null;
            }

            @Override
            public ResultData selcetCouponHistoty(CouponHistory couponHistory) {
                return null;
            }

            @Override
            public ResultData addCouponHistoty(CouponHistory couponHistory) {
                return null;
            }

            @Override
            public ResultData selcetMember(Member member) {
                return null;
            }

            @Override
            public ResultData selcetOrderByMemberId(Order order) {
                return null;
            }

            @Override
            public ResultData selcetCommentById(PageInfos pageInfos) {
                return null;
            }


        };
        return repastService;
    }

}
