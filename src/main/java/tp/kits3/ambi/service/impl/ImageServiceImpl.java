package tp.kits3.ambi.service.impl;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tp.kits3.ambi.dto.PostFileDto;
import tp.kits3.ambi.service.ImageService;
import tp.kits3.ambi.vo.Image;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ServletContext context;
	@Override
	public ResponseEntity<PostFileDto> insert(MultipartFile inputFile) {
		PostFileDto fileInfo = new PostFileDto();
		Image image = new Image();
		String path ="C:\\Users\\PC27\\git\\kits-03-ambition\\src\\main\\webapp\\resources\\albums\\imagesOfPost";
		  HttpHeaders headers = new HttpHeaders();
		  if (!inputFile.isEmpty()) {
		   try {
		    String originalFilename = inputFile.getOriginalFilename();
		    File destinationFile = new File(path +  File.separator + originalFilename);
		    inputFile.transferTo(destinationFile);
			
			  image.setImgName(destinationFile.getPath());
			  image.setDescription(Double.toString(inputFile.getSize()));
			System.out.println(image.getImgName()+"  ||  "+image.getDescription());
		    headers.add("File Uploaded Successfully - ", originalFilename);
		    return new ResponseEntity<PostFileDto>(fileInfo,headers, HttpStatus.OK);
		   } catch (Exception e) {    
			   e.printStackTrace();
		    return new ResponseEntity<PostFileDto>(HttpStatus.BAD_REQUEST);
		   }
		  }else{
		   return new ResponseEntity<PostFileDto>(HttpStatus.BAD_REQUEST);
		  }
	}


}
