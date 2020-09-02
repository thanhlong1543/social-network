package tp.kits3.ambi.vo;

public class NotificationObject {

    private Integer objectId;

    private String object;

    private Integer notiId;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getNotiId() {
        return notiId;
    }

    public void setNotiId(Integer notiId) {
        this.notiId = notiId;
    }

    public void CopyData(NotificationObject param)
    {
        this.objectId = param.getObjectId();
        this.object = param.getObject();
        this.notiId = param.getNotiId();
    }
}
