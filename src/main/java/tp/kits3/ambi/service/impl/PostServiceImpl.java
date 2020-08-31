package tp.kits3.ambi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.converter.CommentConverter;
import tp.kits3.ambi.converter.PostConverter;
import tp.kits3.ambi.dao.CommentDao;
import tp.kits3.ambi.dao.PostDao;
import tp.kits3.ambi.dao.SubcommentDao;
import tp.kits3.ambi.dto.CommentDto;
import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.service.CommentService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.service.SubcommentService;
import tp.kits3.ambi.vo.Comment;
import tp.kits3.ambi.vo.Post;
import tp.kits3.ambi.vo.Subcomment;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDao postDao;
	@Autowired
	CommentDao commentDao;
	@Autowired
	SubcommentDao subcommentDao;
	@Autowired
	PostConverter postConverter;
	@Autowired
	CommentConverter commentConverter;
	@Override
	public List<Post> selectAll() {

		return postDao.selectAll();
	}

	@Override
	public List<Post> selectByUserid(int userId) {
		return postDao.selectByUserid(userId);
	}

	@Override
	public List<PostDto> selectPostInfoByUserid(int userId) {
		List<Post> posts = selectByUserid(userId);
		List<PostDto> postDtos = new ArrayList<PostDto>();
		for (int i = 0; i < posts.size(); i++) {
			PostDto postDto = postConverter.toDto(posts.get(i));
			List<CommentDto> commentDtos = new ArrayList<CommentDto>();
			List<Comment> comments = commentDao.selectByPostid(posts.get(i).getPostId());
			for (Comment comment : comments) {
				List<Subcomment> subcomments = subcommentDao.selectByCommentid(comment.getCommentId());
				CommentDto commentDto = commentConverter.toDto(comment);
				commentDto.setSubComments(subcomments);
				commentDtos.add(commentDto);
			}
			postDto.setComments(commentDtos);
			postDtos.add(postDto);
		}
		return postDtos;
	}

}
