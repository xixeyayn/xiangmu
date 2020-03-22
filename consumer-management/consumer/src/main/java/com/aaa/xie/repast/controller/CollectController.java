package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Collect;
import com.aaa.xie.repast.service.IRepastService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*  @  时间    :  2020/3/16 19:19:53
 *  @  类名    :  CollectController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
@Api(value = "收藏信息", tags = "收藏信息接口(提供收藏所欲有关操作)")
public class CollectController extends BaseController {
    @Autowired
    private IRepastService iRepastService;
    /*
     * @Author Xie
     * @Description 
     *       查询的收藏
     * @Date 19:21 2020/3/16
     * @Param [collect]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectCollectByMemberId")
    public ResultData selectCollectByMemberId(Collect collect){
        return iRepastService.selectCollectByMemberId(collect);
    }
    /*
     * @Author Xie
     * @Description 
     *       更改收藏
     * @Date 19:48 2020/3/16
     * @Param [collect]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/updateCollectByMemberId")
    public ResultData updateCollectByMemberId(Collect collect){
        return iRepastService.updateCollectByMemberId(collect);
    }
}
