package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.CommentReplayMapper;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.CommentReplay;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/*  @  时间    :  2020/3/15 19:36:28
 *  @  类名    :  CommentReplayService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
public class CommentReplayService extends BaseService<CommentReplay> {
    @Autowired
    private CommentReplayMapper commentReplayMapper;
    @Override
    public Mapper<CommentReplay> getMapper() {
        return commentReplayMapper;
    }
    /*
     * @Author Xie
     * @Description 
     *       查询评价回复
     * @Date 19:51 2020/3/15
     * @Param [commentReplay]
     * @return java.util.List<com.aaa.xie.repast.model.CommentReplay>
     **/
    public List<CommentReplay> selcetCommentReplayById(CommentReplay commentReplay){
        List<CommentReplay> commentReplays = queryList(commentReplay);
        return commentReplays;
    }
}
