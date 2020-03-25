package com.aaa.xie.repast.controller;

/*  @  时间    :  2020/3/14 18:55:23
 *  @  类名    :  AddressController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Api(value = "地址信息", tags = "地址接口(提供地址有关操作)")
public class AddressController extends BaseController {
    @Autowired
    private IRepastService repastService;
    @ApiOperation(value = "增加", notes = "增加我的收获地址")
    @PostMapping("/addAddress")
    public ResultData updateAddress(@RequestBody Address address){
        return repastService.addAddress(address);

    }
    /*
     * @Author Xie
     * @Description
     *  删除地址
     * @Date 21:11 2020/3/14
     * @Param [address]
     * @return com.aaa.xie.repast.base.ResultData
     **/@ApiOperation(value = "删除", notes = "删除我的收货地址，假删除")
    @PostMapping("/deleteAddress")
    public ResultData deleteAddress(@RequestBody Address address){
        return repastService.deleteAddress(address);
    };
    /*
     * @Author Xie
     * @Description
     *       查询地址
     * @Date 21:13 2020/3/14
     * @Param [address]
     * @return com.aaa.xie.repast.base.ResultData
     **/@ApiOperation(value = "查询", notes = "查询我的收货地址")
    @PostMapping("/selcetAddress")
    public ResultData selcetAddress(@RequestBody Address address){
        return repastService.selcetAddress(address);
    };
    /*
     * @Author Xie
     * @Description
     *       删除所有地址
     * @Date 21:13 2020/3/14
     * @Param [memberId]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @ApiOperation(value = "删除", notes = "删除选中")
    @PostMapping("/deleteAllAddress")
    public ResultData deleteAllAddress(@RequestBody List id){
        return repastService.deleteAllAddress(id);
    };
    /*
     * @Author Xie
     * @Description
     *       更改状态码
     * @Date 21:13 2020/3/14
     * @Param [memberId]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @ApiOperation(value = "修改", notes = "更能该默认地址")
    @PostMapping("/updateAddressStatus")
    public ResultData updateAddresStatus(@RequestBody Address address){
        return repastService.updateAddresStatus(address);
    }
}
