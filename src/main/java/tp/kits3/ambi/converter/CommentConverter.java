package tp.kits3.ambi.converter;

import org.springframework.stereotype.Component;

import tp.kits3.ambi.dto.CommentDto;
import tp.kits3.ambi.vo.Comment;
/**
 * @author Pham Thanh Tam
 */
@Component
public class CommentConverter {
	public CommentDto toDto(Comment vo) {
		CommentDto dto = new CommentDto();
		dto.setCommentId(vo.getCommentId());
		dto.setContent(vo.getContent());
		dto.setCommentDate(vo.getCommentDate());
		dto.setUserId(vo.getUserId());
		dto.setPostId(vo.getPostId());
		dto.setIsdelete(vo.getIsdelete());
		return dto;
	}

	public Comment toVo(CommentDto dto) {
		Comment vo = new Comment();
		vo.setCommentId(dto.getCommentId());
		vo.setContent(dto.getContent());
		vo.setCommentDate(dto.getCommentDate());
		vo.setUserId(dto.getUserId());
		vo.setPostId(dto.getPostId());
		vo.setIsdelete(dto.getIsdelete());
		return vo;
	}
}
