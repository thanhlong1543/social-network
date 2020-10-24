package tp.kits3.ambi.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tp.kits3.ambi.dao.ImageDao;
import tp.kits3.ambi.dto.PostFileDto;
import tp.kits3.ambi.service.ImageService;
import tp.kits3.ambi.vo.Image;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageDao imagedao;
	@Override
	public ResponseEntity<PostFileDto> insert(MultipartFile inputFile, int postId) {
		PostFileDto fileInfo = new PostFileDto();
		Image image = new Image();
		Image upImg = imagedao.selectByPostid(postId);
		String workDir = System.getProperty("user.home");
		String path =workDir+"\\git\\kits-03-ambition\\src\\main\\webapp\\resources\\albums\\imagesOfPost";
		  HttpHeaders headers = new HttpHeaders();
		  if (!inputFile.isEmpty()) {
		   try {
		    String originalFilename = inputFile.getOriginalFilename();
		    File destinationFile = new File(path +  File.separator + originalFilename);
		    inputFile.transferTo(destinationFile);
		    if(upImg!=null) {
		    	upImg.setImgName(originalFilename);
		    	upImg.setDescription(Double.toString(inputFile.getSize()));
		    	imagedao.update(upImg);
			    headers.add("File Uploaded Successfully - ", originalFilename);
			    return new ResponseEntity<PostFileDto>(fileInfo,headers, HttpStatus.OK);
			}
			  image.setImgName(originalFilename);
			  image.setDescription(Double.toString(inputFile.getSize()));
			  image.setPostId(postId);				  
			  imagedao.insert(image);
		    headers.add("File Uploaded Successfully - ", originalFilename);
		    return new ResponseEntity<PostFileDto>(fileInfo,headers, HttpStatus.OK);
		   } catch (Exception e) {    
			   e.printStackTrace();
		    return new ResponseEntity<PostFileDto>(HttpStatus.BAD_GATEWAY);
		   }
		  }else{
		   return new ResponseEntity<PostFileDto>(HttpStatus.CONFLICT);
		  }
	}
	@Override
	public Image selectByPostid(Integer postId) {
		return imagedao.selectByPostid(postId);
	}


}
