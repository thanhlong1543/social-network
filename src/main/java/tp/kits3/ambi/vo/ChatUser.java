package tp.kits3.ambi.vo;

public class ChatUser {

    private Integer chatId;

    private Integer userId;

    private Boolean isread;

    private Boolean isdelete;

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
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

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public void CopyData(ChatUser param)
    {
        this.chatId = param.getChatId();
        this.userId = param.getUserId();
        this.isread = param.getIsread();
        this.isdelete = param.getIsdelete();
    }
}
