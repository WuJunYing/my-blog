package com.xiaowuu.service.blog;

import com.xiaowuu.entity.blog.BlogComment;
import com.xiaowuu.entity.blog.BlogLeaveMessage;

import java.util.List;

public interface BlogLeaveMessageService {


    /**
     * 查询获取未读留言
     * @return
     */
    List<BlogLeaveMessage> getTodoMessageList();

    /**
     * 获取总留言数
     */
    int getTotalMessage();

    /**
     * 获取月总留言数
     * @param startTime 月初 01-01 00:00:00
     * @param endTime 下个月的第一天 02-01 00:00:00
     * @return
     */
    int getTotalByMonth(String startTime,String endTime);
}
