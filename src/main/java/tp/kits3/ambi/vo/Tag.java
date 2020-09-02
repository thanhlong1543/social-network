package tp.kits3.ambi.vo;

public class Tag {

    private Integer tagId;

    private Integer postId;

    private Integer commentId;

    private Integer userId;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void CopyData(Tag param)
    {
        this.tagId = param.getTagId();
        this.postId = param.getPostId();
        this.commentId = param.getCommentId();
        this.userId = param.getUserId();
    }
}
