package tp.kits3.ambi.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.converter.CommentConverter;
import tp.kits3.ambi.converter.PostConverter;
import tp.kits3.ambi.converter.SubCommentConverter;
import tp.kits3.ambi.dao.CommentDao;
import tp.kits3.ambi.dao.PostDao;
import tp.kits3.ambi.dao.SubcommentDao;
import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.dto.CommentDto;
import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.dto.SubCommentDto;
import tp.kits3.ambi.service.FriendService;
import tp.kits3.ambi.service.ImageService;
import tp.kits3.ambi.service.LikeService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.util.ConverterStringToDate;
import tp.kits3.ambi.vo.Comment;
import tp.kits3.ambi.vo.Image;
import tp.kits3.ambi.vo.Like;
import tp.kits3.ambi.vo.Post;
import tp.kits3.ambi.vo.Subcomment;
import tp.kits3.ambi.vo.User;
/*
 * @author: Pham Thanh Tam
 * */
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDao postDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private SubcommentDao subcommentDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PostConverter postConverter;
	@Autowired
	private CommentConverter commentConverter;
	@Autowired
	private SubCommentConverter subCommentConverter;
	@Autowired
	private ConverterStringToDate converterStringToDate;
	@Autowired
	private FriendService friendService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private LikeService likeService;
	
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
		List<Post> posts = new ArrayList<Post>();
		posts = selectByUserid(userId);
		List<PostDto> postDtos = new ArrayList<PostDto>();
		User user = userDao.selectOne(userId);
		for (int i = 0; i < posts.size(); i++) {
			PostDto postDto = new PostDto();
			postDto = postConverter.toDto(posts.get(i));
			Image image = new Image();
			image = imageService.selectByPostid(postDto.getPostId());
			List<CommentDto> commentDtos = new ArrayList<CommentDto>();
			List<Comment> comments = new ArrayList<Comment>();
			comments = commentDao.selectByPostid(posts.get(i).getPostId());
			Like like = new Like();
			like.setUserId(userId);
			like.setPostId(postDto.getPostId());
			if(likeService.selectByUseridAndPostid(like)==null) {
				postDto.setIslike(false);
			}
			else {
				postDto.setIslike(true);
			}
			for (Comment comment : comments) {
				List<SubCommentDto> subCommentDtos = new ArrayList<SubCommentDto>();
				List<Subcomment> subcomments = new ArrayList<Subcomment>();
				subcomments = subcommentDao.selectByCommentid(comment.getCommentId());
				for (Subcomment subcomment : subcomments) {
					/* transfer from subCommentVO to subCommentDto */
					SubCommentDto subCommentDto = subCommentConverter.toDto(subcomment);
					User userSubComment = new User();
					userSubComment = userDao.selectOne(subCommentDto.getUserId());
					/* add user write subCmt to subCommentDto */
					subCommentDto.setUser(userSubComment);

					/* add subCommnetDto to subcommentDtos List */
					subCommentDtos.add(subCommentDto);
				}
				CommentDto commentDto = new CommentDto();
				commentDto = commentConverter.toDto(comment);
				User commentUser = new User();
				commentUser = userDao.selectOne(commentDto.getUserId());

				/* add SubCommentDto list to commentDto */
				commentDto.setSubComments(subCommentDtos);

				/* add User write Comment to commentDto */
				commentDto.setUser(commentUser);

				/* add commentDto to commentDto list */
				commentDtos.add(commentDto);
			}
			/* add commentDtos list to postDto */
			postDto.setComments(commentDtos);

			/* add user write post to postDto */
			postDto.setUser(user);
			
			/* add image write post to postDto */
			postDto.setImage(image);

			/* add postDto to postDtos list */
			postDtos.add(postDto);
		}
		return postDtos;
	}

	@Override
	public void update(Post post) {
		postDao.update(post);
	}

	@Override
	public void isdelete(int id, int i) {
		postDao.isdelete(id, i);

	}

	@Override
	public void insert(Post post) {
		postDao.insert(post);
	}

	@Override
	public List<PostDto> selectPostInfoUserAndFriendByUserid(int userId) {
		List<PostDto> postDtosOf1 = new ArrayList<PostDto>();
		postDtosOf1 = selectPostInfoByUserid(userId);
		List<User> users = new ArrayList<User>();
		users = friendService.selectByUserId(userId, 2);
		for (User user : users) {
			postDtosOf1.addAll(selectPostInfoByUserid(user.getUserId()));
		}
		for (PostDto postDto : postDtosOf1) {
			Like like = new Like();
			like.setUserId(userId);
			like.setPostId(postDto.getPostId());
			if(likeService.selectByUseridAndPostid(like)==null) {
				postDto.setIslike(false);
			}
			else {
				postDto.setIslike(true);
			}
		}
		Collections.sort(postDtosOf1, new Comparator<PostDto>() {
			public int compare(PostDto o1, PostDto o2) {
				Date dtIn1 = converterStringToDate.stringToDate(o1.getPostDate());
				Date dtIn2 = converterStringToDate.stringToDate(o2.getPostDate());
				return dtIn2.compareTo(dtIn1);
			}
		});
		return postDtosOf1;
	}

	@Override
	public List<PostDto> selectPostByIdPost(int id) {
		Post post = postDao.selectOne(id);
		User user = userDao.selectOne(post.getUserId());
		Image image = imageService.selectByPostid(id);
		PostDto postDto = postConverter.toDto(post);
		List<Comment> cmts = commentDao.selectByPostid(post.getPostId());
		List<CommentDto> cmtDtos = new ArrayList<>();
		for (Comment cmt : cmts) {
			List<Subcomment> subs = subcommentDao.selectByCommentid(cmt.getCommentId());
			List<SubCommentDto> subDtos = new ArrayList<>();
			for(Subcomment sub : subs) {
				SubCommentDto subDto = subCommentConverter.toDto(sub);
				User userSub = userDao.selectOne(sub.getUserId());
				subDto.setUser(userSub);
				subDtos.add(subDto);
			}
			CommentDto cmtDto = commentConverter.toDto(cmt);
			cmtDto.setSubComments(subDtos);
			User userCmt = userDao.selectOne(cmt.getUserId());
			cmtDto.setUser(userCmt);
			cmtDtos.add(cmtDto);
		}
		postDto.setComments(cmtDtos);
		postDto.setImage(image);
		postDto.setUser(user);
		List<PostDto> postDtos = new ArrayList<PostDto>();
		postDtos.add(postDto);
		return postDtos;
	}

	@Override
	public Post selectOneByIdPost(int id) {
		Post post = postDao.selectOne(id);
		return post;
	}

}
