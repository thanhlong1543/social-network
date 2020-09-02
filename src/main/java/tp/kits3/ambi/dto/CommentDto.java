package tp.kits3.ambi.dto;

import java.util.List;

import tp.kits3.ambi.vo.User;

public class CommentDto {
	private Integer commentId;

	private String content;

	private String commentDate;

	private Integer userId;

	private Integer postId;

	private Boolean isdelete;
	
	private String remotion;
	
	private List<SubCommentDto> subComments;
	
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public List<SubCommentDto> getSubComments() {
		return subComments;
	}
	public void setSubComments(List<SubCommentDto> subCommentDtos) {
		this.subComments = subCommentDtos;
	}
	public String getRemotion() {
		return remotion;
	}
	public void setRemotion(String remotion) {
		this.remotion = remotion;
	}
}
