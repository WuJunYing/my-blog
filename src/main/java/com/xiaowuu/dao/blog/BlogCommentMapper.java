package com.xiaowuu.dao.blog;

import com.xiaowuu.entity.blog.BlogComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 评论dao层
 */
@Mapper
public interface BlogCommentMapper {

    /**
     * 查询未读的评论
     * @return
     */
    List<BlogComment> getTodoCommentList();
}
