package com.xiaowuu.entity.blog;

/**
 * 评论表
 */
public class BlogComment {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 评论者id
     */
    private Integer userId;
    /**
     * 评论者ip
     */
    private String userIp;
    /**
     * 评论博客id
     */
    private Integer blogId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private String commentTime;
    /**
     * 评论者昵称 注册的时候的呢称
     */
    private String userName;
    /**
     * 管理员回复
     */
    private String adminReply;
    /**
     * 管理员回复时间
     */
    private String adminReplyTime;
    /**
     * 管理员是否已读
     */
    private Integer isRead;

    private Integer isDeleted;

    private String updateTime;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdminReply() {
        return adminReply;
    }

    public void setAdminReply(String adminReply) {
        this.adminReply = adminReply;
    }

    public String getAdminReplyTime() {
        return adminReplyTime;
    }

    public void setAdminReplyTime(String adminReplyTime) {
        this.adminReplyTime = adminReplyTime;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
