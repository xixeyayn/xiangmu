package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.mapper.AddressMapper;
import com.aaa.xie.repast.mapper.MemberMapper;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.Member;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.util.Sqls;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/*  @  时间    :  2020/3/14 18:31:48
 *  @  类名    :  AddressService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class AddressService extends BaseService<Address> {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Mapper<Address> getMapper() {
        return addressMapper;
    }
    /*
     * @Author Xie
     * @Description 
     *       修改默认地址
     * @Date 17:25 2020/3/15
     * @Param [address]
     * @return java.lang.Boolean
     **/
//
    public Boolean updateAddressStatus(Address address)throws Exception{
      address.setDefaultStatus(0);
        Address address1 =new Address();
        address1.setMemberId(address.getMemberId());
        address1.setId(null);

//        Integer update1 = getBaseService().update(address1);
        List<Address> addresses = queryList(address1);
        List list = new ArrayList();
        for(Address a:addresses){
            list.add(a.getId());
        }
        address1.setDefaultStatus(1);
        Integer integer = updateBatch(address1, list, null);
        if(null!=integer&&integer>=0){
            Integer update = update(address);
            if(null!=update&&update>0){
                return true;
            }else {
                throw new Exception();
            }
        }
        return false;

    }

}
