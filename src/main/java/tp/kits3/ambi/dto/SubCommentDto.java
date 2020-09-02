package tp.kits3.ambi.dto;

import tp.kits3.ambi.vo.User;

public class SubCommentDto {
	private Integer subcommentId;

    private String content;

    private String commentDate;

    private Integer commentId;
    
    private boolean isdelete;
    
	private User user;
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isIsdelete() {
		return isdelete;
	}
	public void setIsdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}


}
