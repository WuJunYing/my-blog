package com.xiaowuu.service.blog;

import com.xiaowuu.dao.blog.BlogCommentMapper;
import com.xiaowuu.entity.blog.BlogComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("blogCommentService")
public class BlogCommentServiceImpl implements BlogCommentService{

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Override
    public List<BlogComment> getTodoCommentList() {
        return blogCommentMapper.getTodoCommentList();
    }

    @Override
    public int getTotalComment() {
        return blogCommentMapper.getTotalComment();
    }

    @Override
    public int getTotalByMonth(String startTime, String endTime) {
        return blogCommentMapper.getTotalByMonth(startTime, endTime);
    }
}
