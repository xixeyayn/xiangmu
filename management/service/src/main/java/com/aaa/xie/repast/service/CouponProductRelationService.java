package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.CouponProductRelationMapper;
import com.aaa.xie.repast.model.CouponHistory;
import com.aaa.xie.repast.model.CouponProductRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/*  @  时间    :  2020/3/21 06:22:30
 *  @  类名    :  CouponProductRelationService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class CouponProductRelationService extends BaseService<CouponProductRelation> {
    @Autowired
    private CouponProductRelationMapper couponProductRelationMapper;
    @Override
    public Mapper<CouponProductRelation> getMapper() {
        return couponProductRelationMapper;
    }
/*
 * @Author Xie
 * @Description 
 *       查询优惠券类别信息
 * @Date 6:25 2020/3/21
 * @Param [couponProductRelation]
 * @return com.aaa.xie.repast.model.CouponProductRelation
 **/
    public CouponProductRelation selectCouponProductRelation(CouponProductRelation couponProductRelation){
        return queryOne(couponProductRelation);
    }
}
