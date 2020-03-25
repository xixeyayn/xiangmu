package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.dynamic.annotation.TDS;
import com.aaa.xie.repast.model.Member;
import com.aaa.xie.repast.service.MemberService;
import com.aaa.xie.repast.utils.Map2BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:53
 * @Description
 **/
@TDS
@RestController
public class MemberController extends CommonController<Member> {

    @Autowired
    private MemberService memberService;

    @Override
    public BaseService<Member> getBaseService() {
        return memberService;
    }

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param [member]
     * @date 2020/3/10
     * @return java.lang.Boolean
     * @throws 
    **/
    @PostMapping("/doLogin")
    public Boolean doLogin(@RequestBody Member member) {
        return memberService.doLogin(member);
    }
    /*
     * @Author Xie
     * @Description 
     *       对于个人信息的修改
     * @Date 18:30 2020/3/14
     * @Param [member]
     * @return java.lang.Boolean
     **/
    @PostMapping("/updateMember")
    public ResultData updateMember(@RequestBody Map member){
        return update(member);

    }
    /*
     * @Author Xie
     * @Description 
     *       查询个人信息
     * @Date 17:12 2020/3/15
     * @Param [token]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectMember")
    public ResultData selcetMember(@RequestBody Map member){
        return selcetOne(member);
    }

}
