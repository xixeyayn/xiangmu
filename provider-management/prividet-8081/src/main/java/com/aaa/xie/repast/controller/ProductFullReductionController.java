package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.dynamic.annotation.TDS;
import com.aaa.xie.repast.mapper.ProductFullReductionMapper;
import com.aaa.xie.repast.model.ProductFullReduction;
import com.aaa.xie.repast.service.ProductFullReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*  @  时间    :  2020/3/22 15:22:23
 *  @  类名    :  ProductFullReductionController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@TDS
@RestController
public class ProductFullReductionController extends CommonController<ProductFullReduction> {
   @Autowired
   private ProductFullReductionService productFullReductionService;
    @Override
    public BaseService<ProductFullReduction> getBaseService() {
        return productFullReductionService;
    }
    @PostMapping("/selectProductFullReduction")
    public ResultData selectProductFullReduction(@RequestBody Map productFullReduction){
        return selcet(productFullReduction);
    }

}
