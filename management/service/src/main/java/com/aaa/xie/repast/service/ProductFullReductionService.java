package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.ProductFullReductionMapper;
import com.aaa.xie.repast.model.ProductFullReduction;
import com.aaa.xie.repast.model.ProductLadder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/*  @  时间    :  2020/3/22 15:12:19
 *  @  类名    :  ProductFullReductionService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class ProductFullReductionService extends BaseService<ProductFullReduction> {
    @Autowired
    private ProductFullReductionMapper productFullReductionMapper;
    @Override
    public Mapper<ProductFullReduction> getMapper() {
        return productFullReductionMapper;
    }



}
