package com.xiaowuu.service.blog;

import com.xiaowuu.entity.blog.BlogComment;
import com.xiaowuu.entity.user.UserAdmin;

import java.util.List;

public interface BlogCommentService {

    /**
     * 查询未读的评论
     * @return
     */
    List<BlogComment> getTodoCommentList();

}
