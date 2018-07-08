package com.xiaowuu.dto;

/**
 * 图表数据
 */
public class ChartDataDTO {

    /**
     * 日期
     */
    private String date;
    /**
     * 评论数
     */
    private Integer commentTotal;
    /**
     * 留言数
     */
    private Integer messageTotal;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(Integer commentTotal) {
        this.commentTotal = commentTotal;
    }

    public Integer getMessageTotal() {
        return messageTotal;
    }

    public void setMessageTotal(Integer messageTotal) {
        this.messageTotal = messageTotal;
    }
}
