package tp.kits3.ambi.dto;

import tp.kits3.ambi.vo.User;
/*
 * @author: Duc
 * */
public class NotificationDto {
	private Integer notiId;

    private Integer userId;

    private Boolean isread;
    
    private String notiDate;
    
    private String content;
    
    private String description;
    
    private Integer memo;
    
    private Integer notiTypeId;
    
    private Integer quant;
    
    private User user;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public NotificationDto(Integer userId, Boolean isread, String notiDate, String content, String description,
			Integer memo, Integer notiTypeId, User user, Integer quant) {
		super();
		this.userId = userId;
		this.isread = isread;
		this.notiDate = notiDate;
		this.content = content;
		this.description = description;
		this.memo = memo;
		this.notiTypeId = notiTypeId;
		this.user = user;
		this.quant = quant;
	}

	public NotificationDto() {}
    
}
