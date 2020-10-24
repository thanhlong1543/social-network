package tp.kits3.ambi.vo;


public class Notifications {

    private Integer notiId;

    private Integer userId;

    private Boolean isread;
    
    private String notiDate;
    
    private String content;
    
    private Integer memo;
    
    private Integer notiTypeId;
    
    private Integer quant;
    
    private Integer idUserActor;

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

	public String getNotiDate() {
		return notiDate;
	}

	public void setNotiDate(String notiDate) {
		this.notiDate = notiDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPostId() {
		return memo;
	}

	public void setPostId(Integer postId) {
		this.memo = postId;
	}

	public Integer getMemo() {
		return memo;
	}

	public void setMemo(Integer memo) {
		this.memo = memo;
	}

	public Integer getNotiTypeId() {
		return notiTypeId;
	}

	public void setNotiTypeId(Integer notiTypeId) {
		this.notiTypeId = notiTypeId;
	}

	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

	public Integer getIdUserActor() {
		return idUserActor;
	}

	public void setIdUserActor(Integer idUserActor) {
		this.idUserActor = idUserActor;
	}

	public Notifications(Integer userId, Boolean isread, String notiDate, String content, Integer memo,
			Integer notiTypeId, Integer quant, Integer idUserActor) {
		super();
		this.userId = userId;
		this.isread = isread;
		this.notiDate = notiDate;
		this.content = content;
		this.memo = memo;
		this.notiTypeId = notiTypeId;
		this.quant = quant;
		this.idUserActor = idUserActor;
	}
	
	public Notifications() {}

	@Override
	public String toString() {
		return "Notifications [notiId=" + notiId + ", userId=" + userId + ", isread=" + isread + ", notiDate="
				+ notiDate + ", content=" + content + ", memo=" + memo + ", notiTypeId=" + notiTypeId + "]";
	}
}
