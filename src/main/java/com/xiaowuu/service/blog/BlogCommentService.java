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


    /**
     * 获取总评论数
     */
    int getTotalComment();

    /**
     * 获取月总评论数
     * @param startTime 月初 01-01 00:00:00
     * @param endTime 下个月的第一天 02-01 00:00:00
     * @return
     */
    int getTotalByMonth(String startTime,String endTime);

}
