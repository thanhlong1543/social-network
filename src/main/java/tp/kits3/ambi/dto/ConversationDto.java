package tp.kits3.ambi.dto;

import java.util.List;

import tp.kits3.ambi.vo.User;



public class ConversationDto{
	private Integer conId;
	private User user;
	private List<ChatDto> chats;

	public Integer getConId() {
		return conId;
	}

	public void setConId(Integer conId) {
		this.conId = conId;
	}

	public List<ChatDto> getChats() {
		return chats;
	}

	public void setChats(List<ChatDto> chats) {
		this.chats = chats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}
