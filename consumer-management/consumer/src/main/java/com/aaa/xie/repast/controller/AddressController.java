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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddressController extends BaseController {
    @Autowired
    private IRepastService repastService;

    @PostMapping("/addAddress")
    public ResultData updateAddress(Address address){
        return repastService.addAddress(address);

    }
    /*
     * @Author Xie
     * @Description
     *  删除地址
     * @Date 21:11 2020/3/14
     * @Param [address]
     * @return com.aaa.xie.repast.base.ResultData
     **/
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
     **/
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
    @PostMapping("/deleteAllAddress")
    public ResultData deleteAllAddress(@RequestBody Integer[] id){
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
    @PostMapping("/updateAddressStatus")
    public ResultData updateAddresStatus(@RequestBody Address address){
        return repastService.updateAddresStatus(address);
    }
}
