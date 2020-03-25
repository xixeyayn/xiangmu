package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.dynamic.annotation.TDS;
import com.aaa.xie.repast.model.ProductLadder;
import com.aaa.xie.repast.service.ProductLadderService;
import com.aaa.xie.repast.staticstatus.IsEmpty;
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
@TDS
@RestController
public class ProductLadderController extends CommonController<ProductLadder> {
    @Autowired
    private ProductLadderService productLadderService;
    @Override
    public BaseService<ProductLadder> getBaseService() {
        return productLadderService;
    }
    @PostMapping("/selectProductLadder")
    public ResultData selectProductLadder(@RequestBody Map productLadder){
            return selcet(productLadder);
    }

}
