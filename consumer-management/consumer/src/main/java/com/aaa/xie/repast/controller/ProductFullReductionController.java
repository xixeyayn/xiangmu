package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.ProductFullReduction;
import com.aaa.xie.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*  @  时间    :  2020/3/25 06:20:05
 *  @  类名    :  ProductFullReductionController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
@Api(value = "满减信息", tags = "满减接口(提供满减有关操作)")
public class ProductFullReductionController extends BaseController {
    @Autowired
    private IRepastService iRepastService;

    @PostMapping("/selectProductFullReduction")
    @ApiOperation(value = "查询", notes = "查询商品满减")
    public ResultData selectProductFullReduction(@RequestBody ProductFullReduction productFullReduction){
        return iRepastService.selectProductFullReduction(productFullReduction);
    }
}
