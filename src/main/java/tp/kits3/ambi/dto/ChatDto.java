package tp.kits3.ambi.dto;

import tp.kits3.ambi.vo.Chat;
import tp.kits3.ambi.vo.User;

public class ChatDto extends Chat {
	
	private Integer userId;
	
	private User user;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
