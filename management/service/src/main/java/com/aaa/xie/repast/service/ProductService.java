package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.OrderMapper;
import com.aaa.xie.repast.mapper.ProductMapper;
import com.aaa.xie.repast.model.Order;
import com.aaa.xie.repast.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/*  @  时间    :  2020/3/20 01:53:03
 *  @  类名    :  ProductService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class ProductService extends BaseService<Product> {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Mapper<Product> getMapper() {
        return productMapper;
    }
    /*
     * @Author Xie
     * @Description 
     *       查询商品信息
     * @Date 4:00 2020/3/21
     * @Param [product]
     * @return java.util.List
     **/
    public Product selectOneProduct(Product product){
        return queryOne(queryOne(product));
    }
}
