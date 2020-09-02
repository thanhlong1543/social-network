package tp.kits3.ambi.vo;

public class Subcomment {

    private Integer subcommentId;

    private String content;

    private String commentDate;

    private Integer commentId;
    
    private String remotion;
    
    private boolean isdelete;
    
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

	public String getRemotion() {
		return remotion;
	}

	public void setRemotion(String emotion) {
		this.remotion = emotion;
	}

	public boolean isIsdelete() {
		return isdelete;
	}

	public void setIsdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}
   
}
