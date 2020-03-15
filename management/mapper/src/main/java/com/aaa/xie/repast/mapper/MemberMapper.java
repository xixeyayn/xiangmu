package com.aaa.xie.repast.mapper;

import com.aaa.xie.repast.model.Member;
import tk.mybatis.mapper.common.Mapper;

public interface MemberMapper extends Mapper<Member> {

    Member selectMemberByOpenId(String openId);


}