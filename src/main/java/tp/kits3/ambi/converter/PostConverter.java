package tp.kits3.ambi.converter;

import org.springframework.stereotype.Component;

import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.vo.Post;
/**
 * @author Pham Thanh Tam
 */
@Component
public class PostConverter {
	public PostDto toDto(Post vo) {
		PostDto dto = new PostDto();
		dto.setPostId(vo.getPostId());
		dto.setPrivacyId(vo.getPrivacyId());
		dto.setPostDate(vo.getPostDate());
		dto.setUserId(vo.getUserId());
		dto.setTotalLike(vo.getTotalLike());
		dto.setContent(vo.getContent());
		dto.setIsdelete(vo.getIsdelete());
		return dto;
	}

	public Post toVo(PostDto dto) {
		Post vo = new Post();
		vo.setPostId(vo.getPostId());
		vo.setPrivacyId(vo.getPrivacyId());
		vo.setPostDate(vo.getPostDate());
		vo.setUserId(vo.getUserId());
		vo.setTotalLike(vo.getTotalLike());
		vo.setContent(vo.getContent());
		vo.setIsdelete(vo.getIsdelete());
		return vo;
	}
}
