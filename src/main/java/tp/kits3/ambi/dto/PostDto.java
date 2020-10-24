package tp.kits3.ambi.dto;

import java.util.List;

import tp.kits3.ambi.vo.Image;
import tp.kits3.ambi.vo.User;

public class PostDto {
	private Integer postId;

    private String content;

    private String postDate;

    private Integer totalLike;

    private Integer userId;

    private Integer privacyId;
    
    private Boolean isdelete;
    
	private List<CommentDto> comments;
	
	private User user;
	
	private Image image;
	
	private Boolean islike;

	public PostDto(Integer postId, String content, String postDate, Integer totalLike, Integer userId,
			Integer privacyId, Boolean isdelete, List<CommentDto> comments, User user, Image image, Boolean islike) {
		super();
		this.postId = postId;
		this.content = content;
		this.postDate = postDate;
		this.totalLike = totalLike;
		this.userId = userId;
		this.privacyId = privacyId;
		this.isdelete = isdelete;
		this.comments = comments;
		this.user = user;
		this.image = image;
		this.islike = islike;
	}

	public PostDto() {
		super();
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

	public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Boolean getIslike() {
		return islike;
	}

	public void setIslike(Boolean islike) {
		this.islike = islike;
	}
	
	
}
