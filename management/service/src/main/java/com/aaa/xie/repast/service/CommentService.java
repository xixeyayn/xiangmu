package com.aaa.xie.repast.service;

import com.aaa.xie.repast.base.BaseService;
import com.aaa.xie.repast.mapper.AddressMapper;
import com.aaa.xie.repast.mapper.CommentMapper;
import com.aaa.xie.repast.model.Address;
import com.aaa.xie.repast.model.Comment;
import com.aaa.xie.repast.model.CommentReplay;
import com.aaa.xie.repast.model.Member;
import com.aaa.xie.repast.page.PageInfos;
import com.aaa.xie.repast.staticstatus.IsEmpty;
import com.aaa.xie.repast.staticstatus.StaticCode;
import com.aaa.xie.repast.upload.UploadService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.aaa.xie.repast.staticstatus.StaticCode.FORMAT_DATE;

/*  @  时间    :  2020/3/15 19:02:04
 *  @  类名    :  CommentService
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
@Service
public class CommentService extends BaseService<Comment> {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentReplayService commentReplayService;
    @Autowired
    private UploadService uploadService;

    @Override
    public Mapper<Comment> getMapper() {
        return commentMapper;
    }

    /*
     * @Author Xie
     * @Description
     *       查找评价
     *
     * @Date 19:32 2020/3/15
     * @Param [pageInfo]
     * @return com.github.pagehelper.PageInfo
     **/
    public PageInfos selcetCommentById(PageInfos pageInfos) {
        if (pageInfos.getPageNum() < 0) pageInfos.setPageNum(1);
        Comment comment = new Comment();
        List list = (List) pageInfos.getT();
        Comment comment1 = (Comment) list.get(0);
        comment.setMemberIp(comment1.getMemberIp());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageInfos.getPageNum());
        pageInfo.setPageSize(pageInfos.getPageSize());
        pageInfo.setList((List) pageInfos.getT());
        pageInfo = queryListByPage(comment, pageInfo);
        for (Comment c : (List<Comment>) pageInfo.getList()) {
            CommentReplay commentReplay = new CommentReplay();
            commentReplay.setCommentId(c.getId());
            List<CommentReplay> commentReplays = commentReplayService.selcetCommentReplayById(commentReplay);
            c.setCommentReplay(commentReplays);
        }
        pageInfos.setT(pageInfo.getList());
        pageInfos.setPageNum(pageInfo.getPageNum());
        pageInfos.setPageSize(pageInfo.getPageSize());
        return pageInfos;
    }

    public Boolean addComment(Comment comment) {
        try {
            if (IsEmpty.isEmpty(comment)) {
                String pic = "";
                for (MultipartFile m : comment.getImgs()) {
                    String imgName = UUID.randomUUID().toString().replace("-", "");
                    uploadService.upload(m, imgName);
                    pic = imgName + ",";
                }
                comment.setPics(pic);
                if (IsEmpty.isEmpty(add(comment))) {
                    return true;
                } else {
                    return false;
                }
            }
            throw new Exception();
        }catch (Exception e){

        }

        return null;

    }
}
