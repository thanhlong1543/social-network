package tp.kits3.ambi.vo;

public class Comment {

    private Integer commentId;

    private String content;

    private String commentDate;

    private Integer userId;

    private Integer postId;

    private Boolean isdelete;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
    public void CopyData(Comment param)
    {
        this.commentId = param.getCommentId();
        this.content = param.getContent();
        this.commentDate = param.getCommentDate();
        this.userId = param.getUserId();
        this.postId = param.getPostId();
        this.isdelete = param.getIsdelete();
    }
}
