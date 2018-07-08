package com.xiaowuu.dao.blog;

import com.xiaowuu.entity.blog.BlogComment;
import com.xiaowuu.entity.blog.BlogLeaveMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 留言ao层
 */
@Mapper
public interface BlogLeaveMessageMapper {

    /**
     * 查询未读的留言
     * @return
     */
    List<BlogLeaveMessage> getTodoMessageList();


    /**
     * 获取总；留言数
     */
    int getTotalMessage();

    /**
     * 获取月留言数
     * @param startTime 月初 01-01 00:00:00
     * @param endTime 下个月的第一天 02-01 00:00:00
     * @return
     */
    int getTotalByMonth(@Param("startTime") String startTime, @Param("endTime") String endTime);
}
