package tp.kits3.ambi.vo;

public class Like {

    private Integer likeId;

    private Integer postId;

    private Integer userId;

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void CopyData(Like param)
    {
        this.likeId = param.getLikeId();
        this.postId = param.getPostId();
        this.userId = param.getUserId();
    }
}
