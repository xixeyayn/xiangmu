package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;

import com.aaa.xie.repast.base.ResultData;

import com.aaa.xie.repast.model.ProductLadder;
import com.aaa.xie.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*  @  时间    :  2020/3/22 15:17:07
 *  @  类名    :  ProductLadderController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
@Api(value = "阶梯信息", tags = "阶梯接口(提供阶梯有关操作)")
public class ProductLadderController extends BaseController {
    @Autowired
    private IRepastService iRepastService;

    @PostMapping("/selectProductLadder")
    @ApiOperation(value = "查询", notes = "查询商品阶梯价格")
    public ResultData selectProductLadder(@RequestBody ProductLadder productLadder){
            return iRepastService.selectProductLadder(productLadder);
    }

}
