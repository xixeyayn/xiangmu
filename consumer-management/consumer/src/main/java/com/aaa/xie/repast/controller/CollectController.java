package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Collect;
import com.aaa.xie.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    @ApiOperation(value = "查询", notes = "查询我的收藏")
    @PostMapping("/selectCollectByMemberId")
    public ResultData selectCollectByMemberId(@RequestBody Collect collect){
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
    @ApiOperation(value = "修改", notes = "修改我的收藏s")
    @PostMapping("/updateCollectByMemberId")
    public ResultData updateCollectByMemberId(@RequestBody Collect collect){
        return iRepastService.updateCollectByMemberId(collect);
    }
    @ApiOperation(value = "增加", notes = "修改我的收藏s")
    @PostMapping("/addCollect")
    public ResultData addCollect(@RequestBody Collect collect){
        return iRepastService.addCollect(collect);
    }


}
