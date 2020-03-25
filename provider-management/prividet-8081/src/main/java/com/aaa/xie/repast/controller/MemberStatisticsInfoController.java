package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.dynamic.annotation.TDS;
import com.aaa.xie.repast.model.MemberStatisticsInfo;
import com.aaa.xie.repast.service.MemberStatisticsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/*  @  时间    :  2020/3/20 01:32:31
 *  @  类名    :  MemberStatisticsInfoController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@TDS
public class MemberStatisticsInfoController extends CommonController<MemberStatisticsInfo> {
    @Autowired
    private MemberStatisticsInfoService memberStatisticsInfoService;
    @Override
    public BaseService<MemberStatisticsInfo> getBaseService() {
        return memberStatisticsInfoService;
    }
    /*
     * @Author Xie
     * @Description 
     *       查询个人详细信息
     * @Date 1:38 2020/3/20
     * @Param [memberStatisticsInfo]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectmemberStatisticsInfoByMemberId")
    public ResultData selectmemberStatisticsInfoByMemberId(@RequestBody Map memberStatisticsInfo){
        return selcet(memberStatisticsInfo);
    }
}
