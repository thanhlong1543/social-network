package tp.kits3.ambi.vo;

public class NotificationAction {

    private Integer notiId;

    private String action;

    private String actor;

    private Integer objectId;

    public Integer getNotiId() {
        return notiId;
    }

    public void setNotiId(Integer notiId) {
        this.notiId = notiId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public void CopyData(NotificationAction param)
    {
        this.notiId = param.getNotiId();
        this.action = param.getAction();
        this.actor = param.getActor();
        this.objectId = param.getObjectId();
    }
}