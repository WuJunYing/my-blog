package com.xiaowuu.service.blog;

import com.xiaowuu.dao.blog.BlogCommentMapper;
import com.xiaowuu.dao.blog.BlogLeaveMessageMapper;
import com.xiaowuu.entity.blog.BlogComment;
import com.xiaowuu.entity.blog.BlogLeaveMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("blogLeaveMessageService")
public class BlogLeaveMessageServiceImpl implements BlogLeaveMessageService{

    @Autowired
    private BlogLeaveMessageMapper blogLeaveMessageMapper;

    @Override
    public List<BlogLeaveMessage> getTodoMessageList() {
        return blogLeaveMessageMapper.getTodoMessageList();
    }

    @Override
    public int getTotalMessage() {
        return blogLeaveMessageMapper.getTotalMessage();
    }

    @Override
    public int getTotalByMonth(String startTime, String endTime) {
        return blogLeaveMessageMapper.getTotalByMonth(startTime, endTime);
    }
}
