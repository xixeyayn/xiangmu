package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.Member;
import com.aaa.xie.repast.service.AddressService;
import com.aaa.xie.repast.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*  @  时间    :  2020/3/14 18:47:24
 *  @  类名    :  AddressController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
public class AddressController extends CommonController<Address> {

    @Autowired
    private AddressService addressService;

    @Override
    public BaseService<Address> getBaseService() {
        return addressService;
    }
    /**
     * 新增收货地址
     * @param ResultData
     * @return
     */
    @PostMapping("/addAddress")
    public ResultData AddAdderss(@RequestBody Map address){
        return add(address);
    }
    /**
     * @Author Xie
     * @Description 
     *       修改地址
     * @Date 19:17 2020/3/14
     * @Param [address]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/updateAddress")
    public ResultData updateAddress(@RequestBody Map address){
       return update(address);
    }


    /**
     * @Author Xie
     * @Description 
     *       删除地址
     * @Date 19:20 2020/3/14
     * @Param [address]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/deleteAddress")
    public ResultData deleteAddress(@RequestBody Map address){
      return delete(address);
    }
    /*
     * @Author Xie
     * @Description 
     *       批量删除地址
     * @Date 19:22 2020/3/14
     * @Param [addressid]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/deleteAllAddress")
    public ResultData deleteAllAddress(@RequestBody Integer[] id ){
       return batchDelete(id);
    }
    /*
     * @Author Xie
     * @Description 
     *       查询的方法
     * @Date 21:09 2020/3/14
     * @Param [address]
     * @return org.springframework.web.bind.annotation.RequestBody
     **/
    @PostMapping("/selcetAddress")
    public ResultData selcetAddress(@RequestBody Map address){
        return selcet(address);
    }
    
    /*
     * @Author Xie
     * @Description 
     *       修改默认地址
     * @Date 21:23 2020/3/14
     * @Param [id]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/updateAddressStatus")
    public ResultData updateAddresStatus(@RequestBody Address address)throws Exception{
        Boolean aBoolean = addressService.updateAddressStatus(address);
        if(aBoolean==true){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }

    }
}
