package tp.kits3.ambi.vo;

public class Post {

    private Integer postId;

    private String content;

    private String postDate;

    private Integer totalLike;

    private Integer userId;

    private Integer privacyId;

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

    public void CopyData(Post param)
    {
        this.postId = param.getPostId();
        this.content = param.getContent();
        this.postDate = param.getPostDate();
        this.totalLike = param.getTotalLike();
        this.userId = param.getUserId();
        this.privacyId = param.getPrivacyId();
    }
}
