package tp.kits3.ambi.converter;

import org.springframework.stereotype.Component;

import tp.kits3.ambi.dto.NotificationDto;
import tp.kits3.ambi.util.TimeCalculation;
import tp.kits3.ambi.vo.Notifications;
/*
 * @author: Duc
 * */
@Component
public class NotificationConverter {
	public NotificationDto toDto(Notifications vo) {
		NotificationDto dto = new NotificationDto();
		dto.setNotiId(vo.getNotiId());
		dto.setUserId(vo.getUserId());
		dto.setIsread(vo.getIsread());
		dto.setNotiDate(TimeCalculation.calculate(vo.getNotiDate()));
		dto.setContent(vo.getContent());
		dto.setNotiTypeId(vo.getNotiTypeId());
		dto.setMemo(vo.getMemo());
		dto.setQuant(vo.getQuant());
		return dto;
	}
}
