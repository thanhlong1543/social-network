package tp.kits3.ambi.vo;

public class Friend {

    private Integer friendId;

    private Integer use1Id;

    private Integer user2Id;

    private Integer reId;

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getUse1Id() {
        return use1Id;
    }

    public void setUse1Id(Integer use1Id) {
        this.use1Id = use1Id;
    }

    public Integer getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public void CopyData(Friend param)
    {
        this.friendId = param.getFriendId();
        this.use1Id = param.getUse1Id();
        this.user2Id = param.getUser2Id();
        this.reId = param.getReId();
    }
}
