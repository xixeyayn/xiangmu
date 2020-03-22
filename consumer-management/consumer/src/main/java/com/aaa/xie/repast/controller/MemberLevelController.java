package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.service.IRepastService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*  @  时间    :  2020/3/20 01:36:32
 *  @  类名    :  MemberLevelController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
@Api(value = "等级信息", tags = "等级接口(提供等级有关操作)")
public class MemberLevelController extends BaseController {
    @Autowired
    private IRepastService iRepastService;
/*
 * @Author Xie
 * @Description 
 *       查询会员等级
 * @Date 1:48 2020/3/20
 * @Param []
 * @return com.aaa.xie.repast.base.ResultData
 **/
    @PostMapping("/selectMemberLevel")
    public ResultData selectMemberLevel(){
        return selectMemberLevel();
    }
}
