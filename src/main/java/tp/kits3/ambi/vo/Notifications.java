package tp.kits3.ambi.vo;

public class Notifications {

    private Integer notiId;

    private Integer userId;

    private Boolean isread;

    public Integer getNotiId() {
        return notiId;
    }

    public void setNotiId(Integer notiId) {
        this.notiId = notiId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getIsread() {
        return isread;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }

    public void CopyData(Notifications param)
    {
        this.notiId = param.getNotiId();
        this.userId = param.getUserId();
        this.isread = param.getIsread();
    }
}
