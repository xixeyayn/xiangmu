package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.model.Comment;
import com.aaa.xie.repast.page.PageInfos;
import com.aaa.xie.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*  @  时间    :  2020/3/15 20:15:05
 *  @  类名    :  CommentController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
@Api(value = "评价信息", tags = "评价信息接口(提供评价有关操作)")
public class CommentController extends BaseController {
    @Autowired
    private IRepastService repastService;
    /*
     * @Author Xie
     * @Description 
     *       查找评价及评价回复
     * @Date 20:24 2020/3/15
     * @Param [pageInfos]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @ApiOperation(value = "查询", notes = "查询我的评价")
    @PostMapping("/selcetCommentById")
    public ResultData selcetCommentById(@RequestBody PageInfos pageInfos){
        return repastService.selcetCommentById(pageInfos);
    }
    @PostMapping("/addComment")
    public ResultData addComment(@RequestBody Comment comment){
        return repastService.addComment(comment);
    }

}
