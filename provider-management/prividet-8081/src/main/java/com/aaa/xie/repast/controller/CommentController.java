package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.base.CommonController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.dynamic.annotation.TDS;
import com.aaa.xie.repast.model.Comment;
import com.aaa.xie.repast.page.PageInfos;
import com.aaa.xie.repast.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*  @  时间    :  2020/3/15 19:48:08
 *  @  类名    :  CommentController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@TDS
@RestController
public class CommentController extends CommonController<Comment> {
    @Autowired
    private CommentService commentService;
    @Override
    public BaseService<Comment> getBaseService() {
        return commentService;
    }
    /*
     * @Author Xie
     * @Description 
     *       查找评价及评价回复
     * @Date 20:08 2020/3/15
     * @Param [pageInfo]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selcetCommentById")
    public ResultData selcetCommentById(@RequestBody PageInfos pageInfos){
        pageInfos=commentService.selcetCommentById(pageInfos);
        if(pageInfos!=null){
            return super.operationSuccess(pageInfos);
        }else {
            return super.operationFailed();
        }
    }
    @PostMapping("/addComment")
    public ResultData addComment(@RequestBody Comment comment){
        if(commentService.addComment(comment)){
            return operationSuccess();
        }
        return super.operationFailed();
    }


}
