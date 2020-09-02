package tp.kits3.ambi.vo;

public class Conversation {

    private Integer conId;

    private Integer ownerId;

    private String title;

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void CopyData(Conversation param)
    {
        this.conId = param.getConId();
        this.ownerId = param.getOwnerId();
        this.title = param.getTitle();
    }
}