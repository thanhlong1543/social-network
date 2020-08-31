package tp.kits3.ambi.vo;

public class Chat {

    private Integer chatId;

    private Integer conId;

    private String content;

    private String chatTime;

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChatTime() {
        return chatTime;
    }

    public void setChatTime(String chatTime) {
        this.chatTime = chatTime;
    }

    public void CopyData(Chat param)
    {
        this.chatId = param.getChatId();
        this.conId = param.getConId();
        this.content = param.getContent();
        this.chatTime = param.getChatTime();
    }
}
