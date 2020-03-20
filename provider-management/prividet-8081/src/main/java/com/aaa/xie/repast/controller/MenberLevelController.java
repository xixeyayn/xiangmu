package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.mapper.MemberLevelMapper;
import com.aaa.xie.repast.model.MemberLevel;
import com.aaa.xie.repast.service.MemberLevelService;
import com.aaa.xie.repast.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

/*  @  时间    :  2020/3/20 01:20:24
 *  @  类名    :  MenberLevelController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
public class MenberLevelController extends CommonController<MemberLevel> {
    @Autowired
    private MemberLevelService memberLevelService;
    @Override
    public BaseService<MemberLevel> getBaseService() {
        return memberLevelService;
    }
    /*
     * @Author Xie
     * @Description 
     *       查询会员等级
     * @Date 1:29 2020/3/20
     * @Param []
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selectMemberLevel")
    public ResultData selectMemberLevel(){
        return selcet(new HashMap());
    }
}
