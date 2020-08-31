package tp.kits3.ambi.dto;

import java.util.List;

import tp.kits3.ambi.vo.User;

public class PostDto {
	private Integer postId;

    private String content;

    private String postDate;

    private Integer totalLike;

    private Integer userId;

    private Integer privacyId;
	private List<CommentDto> comments;
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public Integer getTotalLike() {
		return totalLike;
	}
	public void setTotalLike(Integer totalLike) {
		this.totalLike = totalLike;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPrivacyId() {
		return privacyId;
	}
	public void setPrivacyId(Integer privacyId) {
		this.privacyId = privacyId;
	}
	public List<CommentDto> getComments() {
		return comments;
	}
	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}	
	
}
