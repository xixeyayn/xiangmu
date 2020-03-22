package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.ProductLadderMapper;
import com.aaa.xie.repast.mapper.ProductMapper;
import com.aaa.xie.repast.model.Product;
import com.aaa.xie.repast.model.ProductLadder;
import com.aaa.xie.repast.staticstatus.IsEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/*  @  时间    :  2020/3/22 15:04:10
 *  @  类名    :  ProductLadderService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class ProductLadderService extends BaseService<ProductLadder> {
    @Autowired
    private ProductLadderMapper productLadderMapper;
    @Override
    public Mapper<ProductLadder> getMapper() {
        return productLadderMapper;
    }


}
