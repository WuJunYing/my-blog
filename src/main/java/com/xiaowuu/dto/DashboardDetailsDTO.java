package com.xiaowuu.dto;

/**
 * 首页各项总数
 */
public class DashboardDetailsDTO {

    /**
     * 总评论数
     */
    private Integer totalComment;
    /**
     * 未读评论数
     */
    private Integer readTotalComment;
    /**
     * 总留言数
     */
    private Integer totalMessage;
    /**
     * 未读留言数
     */
    private Integer readTotalMessage;

    public Integer getTotalComment() {
        return totalComment;
    }

    public void setTotalComment(Integer totalComment) {
        this.totalComment = totalComment;
    }

    public Integer getReadTotalComment() {
        return readTotalComment;
    }

    public void setReadTotalComment(Integer readTotalComment) {
        this.readTotalComment = readTotalComment;
    }

    public Integer getTotalMessage() {
        return totalMessage;
    }

    public void setTotalMessage(Integer totalMessage) {
        this.totalMessage = totalMessage;
    }

    public Integer getReadTotalMessage() {
        return readTotalMessage;
    }

    public void setReadTotalMessage(Integer readTotalMessage) {
        this.readTotalMessage = readTotalMessage;
    }
}
