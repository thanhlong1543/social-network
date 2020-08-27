package tp.kits3.ambi.vo;

public class ConversationUser {

    private Integer conId;

    private Integer userId;

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void CopyData(ConversationUser param)
    {
        this.conId = param.getConId();
        this.userId = param.getUserId();
    }
}
