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
		dto.setContent(vo.getContent());
		dto.setCommentDate(vo.getCommentDate());
		dto.setSubcommentId(vo.getSubcommentId());
		return dto;
	}

	public Subcomment toVo(SubCommentDto dto) {
		Subcomment vo = new Subcomment();
		vo.setCommentId(vo.getCommentId());
		vo.setContent(vo.getContent());
		vo.setCommentDate(vo.getCommentDate());
		vo.setSubcommentId(vo.getSubcommentId());
		return vo;
	}
}
