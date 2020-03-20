package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.CouponProductCategoryRelationMapper;
import com.aaa.xie.repast.mapper.MemberMapper;
import com.aaa.xie.repast.model.CouponProductCategoryRelation;
import com.aaa.xie.repast.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/*  @  时间    :  2020/3/21 06:14:54
 *  @  类名    :  CouponProductCategoryRelationService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class CouponProductCategoryRelationService extends BaseService<CouponProductCategoryRelation> {
    @Autowired
    private CouponProductCategoryRelationMapper couponProductCategoryRelationMapper;

    @Override
    public Mapper<CouponProductCategoryRelation> getMapper() {
        return couponProductCategoryRelationMapper;
    }
    /*
     * @Author Xie
     * @Description 
     *       查询优惠券的产品关系
     * @Date 6:21 2020/3/21
     * @Param [couponProductCategoryRelation]
     * @return com.aaa.xie.repast.model.CouponProductCategoryRelation
     **/
    public CouponProductCategoryRelation selectCouponProductCategoryRelation(CouponProductCategoryRelation couponProductCategoryRelation){
        return queryOne(couponProductCategoryRelation);
    }
}
