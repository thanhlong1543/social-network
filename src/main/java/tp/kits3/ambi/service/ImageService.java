package tp.kits3.ambi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import tp.kits3.ambi.dto.PostFileDto;

public interface ImageService {

	ResponseEntity<PostFileDto> insert(MultipartFile inputFile);

}
