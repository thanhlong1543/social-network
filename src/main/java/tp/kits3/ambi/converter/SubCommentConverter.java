package tp.kits3.ambi.converter;

import org.springframework.stereotype.Component;

import tp.kits3.ambi.dto.SubCommentDto;
import tp.kits3.ambi.vo.Subcomment;
/**
 * @author Pham Thanh Tam
 */
@Component
public class SubCommentConverter {
	public SubCommentDto toDto(Subcomment vo) {
		SubCommentDto dto = new SubCommentDto();
		dto.setCommentId(vo.getCommentId());
		dto.setUserId(vo.getUserId());
		dto.setContent(vo.getContent());
		dto.setCommentDate(vo.getCommentDate());
		dto.setIsdelete(vo.isIsdelete());
		dto.setSubcommentId(vo.getSubcommentId());
		return dto;
	}

	public Subcomment toVo(SubCommentDto dto) {
		Subcomment vo = new Subcomment();
		vo.setCommentId(dto.getCommentId());
		vo.setIsdelete(dto.isIsdelete());
		vo.setUserId(dto.getUserId());
		vo.setContent(dto.getContent());
		vo.setCommentDate(dto.getCommentDate());
		vo.setSubcommentId(dto.getSubcommentId());
		return vo;
	}
}
