package tp.kits3.ambi.converter;

import org.springframework.stereotype.Component;

import tp.kits3.ambi.dto.ChatDto;
import tp.kits3.ambi.vo.Chat;
/**
 * @author Pham Thanh Tam
 */
@Component
public class ConversationConverter {
	public ChatDto toDto(Chat vo) {
		ChatDto dto = new ChatDto();
		dto.setChatId(vo.getChatId());
		dto.setConId(vo.getConId());
		dto.setContent(vo.getContent());
		dto.setChatTime(vo.getChatTime());
		return dto;
	}

	public Chat toVo(ChatDto dto) {
		Chat vo = new Chat();
		vo.setChatId(dto.getChatId());
		vo.setConId(dto.getConId());
		vo.setChatTime(dto.getChatTime());
		vo.setContent(dto.getContent());
		return vo;
	}
}
