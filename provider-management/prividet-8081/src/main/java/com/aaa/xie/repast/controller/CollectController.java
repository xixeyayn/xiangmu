package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Collect;
import com.aaa.xie.repast.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*  @  时间    :  2020/3/16 19:09:00
 *  @  类名    :  collectController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
public class CollectController extends CommonController<Collect> {
    @Autowired
    private CollectService collectService;
    @Override
    public BaseService<Collect> getBaseService() {
        return collectService;
    }
    /*
     * @Author Xie
     * @Description 
     *       查询收藏的
     * @Date 19:13 2020/3/16
     * @Param [collect]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectCollectByMemberId")
    public ResultData selectCollectByMemberId(Map collect){
        return selcet(collect);
    }
    /*
     * @Author Xie
     * @Description 
     *       增加收藏的
     * @Date 19:13 2020/3/16
     * @Param [collect]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/addCollect")
    public ResultData addCollect(Map collect)throws Exception{
        if(null!=collect.get("memberId")){
            throw new Exception("没有会员id");
        }
        return add(collect);
    }
    /*
     * @Author Xie
     * @Description 
     *       更改收藏
     * @Date 19:13 2020/3/16
     * @Param [collect]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/updateCollectByMemberId")
    public ResultData updateCollectByMemberId(Map collect){
        return update(collect);
    }
}
