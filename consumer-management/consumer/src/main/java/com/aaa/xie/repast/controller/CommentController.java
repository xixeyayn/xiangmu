package com.aaa.xie.repast.controller;

import com.aaa.xie.repast.base.BaseController;
import com.aaa.xie.repast.base.ResultData;
import com.aaa.xie.repast.page.PageInfos;
import com.aaa.xie.repast.service.IRepastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*  @  时间    :  2020/3/15 20:15:05
 *  @  类名    :  CommentController
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@RestController
public class CommentController extends BaseController {
    @Autowired
    private IRepastService repastService;
    /*
     * @Author Xie
     * @Description 
     *       查找评价及评价回复
     * @Date 20:16 2020/3/15
     * @Param [pageInfos]
     * @return com.aaa.xie.repast.base.ResultData
     **/
    @PostMapping("/selcetCommentById")
    public ResultData selcetCommentById(PageInfos pageInfos){
        return repastService.selcetCommentById(pageInfos);
    }
    

}
