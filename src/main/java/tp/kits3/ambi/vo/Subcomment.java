package tp.kits3.ambi.vo;

public class Subcomment {

    private Integer subcommentId;

    private String content;

    private String commentDate;

    private Integer commentId;

    public Integer getSubcommentId() {
        return subcommentId;
    }

    public void setSubcommentId(Integer subcommentId) {
        this.subcommentId = subcommentId;
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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
    public void CopyData(Subcomment param)
    {
        this.subcommentId = param.getSubcommentId();
        this.content = param.getContent();
        this.commentDate = param.getCommentDate();
        this.commentId = param.getCommentId();
    }
}
