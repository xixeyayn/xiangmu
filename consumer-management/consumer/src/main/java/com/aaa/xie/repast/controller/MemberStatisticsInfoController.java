package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.MemberStatisticsInfo;
import com.aaa.xie.repast.service.IRepastService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*  @  时间    :  2020/3/20 01:39:40
 *  @  类名    :  MemberStatisticsInfoController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
@Api(value = "个人详细信息", tags = "个人详细信息接口(提供个人详细信息有关操作)")
public class MemberStatisticsInfoController extends BaseController {
    @Autowired
    private IRepastService iRepastService;
    /*
     * @Author Xie
     * @Description 
     *       查询个人详细信息
     * @Date 1:40 2020/3/20
     * @Param [memberStatisticsInfo]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectmemberStatisticsInfoByMemberId")
    public ResultData selectmemberStatisticsInfoByMemberId(MemberStatisticsInfo memberStatisticsInfo){
        return iRepastService.selectmemberStatisticsInfoByMemberId(memberStatisticsInfo);
    }
}
