package tp.kits3.ambi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.LikeDao;
import tp.kits3.ambi.service.LikeService;
@Service
public class LikeServiceImpl implements LikeService{
	@Autowired
	LikeDao likeDao;
}
