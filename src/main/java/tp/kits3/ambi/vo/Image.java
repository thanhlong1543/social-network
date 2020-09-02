package tp.kits3.ambi.vo;

public class Image {

    private Integer imageId;

    private String imgName;

    private String description;

    private Integer userId;

    private Integer postId;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void CopyData(Image param)
    {
        this.imageId = param.getImageId();
        this.imgName = param.getImgName();
        this.description = param.getDescription();
        this.userId = param.getUserId();
        this.postId = param.getPostId();
    }
}
