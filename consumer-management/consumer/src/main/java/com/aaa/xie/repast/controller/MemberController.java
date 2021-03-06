package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.annotation.LoginLogAnnotation;
import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Member;
import com.aaa.xie.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:13
 * @Description
 **/
@RestController
@Api(value = "用户信息", tags = "用户信息接口(提供用户所欲有关操作)")
public class MemberController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     *      member这个参数是由微信过来的--->并不知道自己数据库中的member_id是多少
     *      只会传递open_id
     * @param [member]
     * @date 2020/3/10
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
    **/
    @PostMapping("/doLogin")
    @ApiOperation(value = "登录", notes = "用户执行登录操作(接收微信端传递数据)")
    @LoginLogAnnotation(operationType = "登录操作", operationName = "普通用户登录")
    public ResultData doLogin(@RequestBody Member member) {
        // 需要调用api工程(feign)
        Boolean ifSuccess = repastService.doLogin(member);
        if(ifSuccess) {
            return super.loginSuccess();
        }
        return super.loginFailed();
    }

    @PostMapping("/updateMember")
    @ApiOperation(value = "修改", notes = "修改用户资料")
    public ResultData updateMember(@RequestBody Member member){

        ResultData resultData = repastService.updateMember(member);
     return resultData;
    }
    /*
     * @Author Xie
     * @Description 
     *       查询个人信息
     * @Date 17:20 2020/3/15
     * @Param [member]
     * @return com.aaa.xie.repast.base.ResultData
     **/

    @PostMapping("/selectMember")
    @ApiOperation(value = "查询", notes = "查询用户个人基础信息")
    public ResultData selcetMember(@RequestBody Member member){
        return repastService.selcetMember(member);
    }



}
