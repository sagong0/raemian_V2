package raemian.common.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import raemian.common.UploadFile;

@Getter @Setter 
@Service
public class FileSaveService {
	
	Logger log = LoggerFactory.getLogger(FileSaveService.class);
	
	@Value("${file.dir}")
	private String fileDir;
	
	public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
		
		log.info("fileDir = {} ", fileDir);
		
        // image.png (고객이 업로드한 파일명)
        String originalFilename = multipartFile.getOriginalFilename();
        String storedFileName = createStoredFileName(originalFilename);
        // 저장
        multipartFile.transferTo(new File(getFullPath(storedFileName)));
        return new UploadFile(originalFilename, storedFileName);
    }
	
	
	
	public String getFullPath(String fileName){
        return fileDir + fileName;
    }
	
	/** 편의 메서드 **/
    // return 서버에 저장할 파일명
    private String createStoredFileName(String originalFilename) {
        // 확장자 추출
        String ext = extractExt(originalFilename);
        // 서버에 저장하는 파일명
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }
    
    // 확장자 추출 메서드
    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos+1);
    }
}
