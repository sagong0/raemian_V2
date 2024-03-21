package raemian.common.service;

import java.util.UUID;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import raemian.common.UploadFile;

@Service
public class CdnService {
	
	private String cdn_url = "http://sagong0.cdn1.cafe24.com/files/";
	private String host = "iup.cdn1.cafe24.com";
    private String user = "sagong0";
    private String password = "wjd461352";
    private int port =21;
    
	Logger log = LoggerFactory.getLogger(CdnService.class);
    
    public UploadFile uploadFile(MultipartFile mfile) {
    	String originalFileName = mfile.getOriginalFilename();
    	String storeFileName = createStoredFileName(originalFileName);
    	
		FTPClient ftp = new FTPClient();
		ftp.setControlEncoding("utf-8");
		FTPClientConfig cf = new FTPClientConfig();
		
		ftp.configure(cf);
		try {
			ftp.connect(host,port); 
			
			if(ftp.login(this.user, this.password)) {
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
				
				/* FTP 파일 업로드 PART */
				boolean result = ftp.storeFile("/www/files/"+storeFileName, mfile.getInputStream());
				if(result) {
					log.info("CDN UPLOAD SUCCESS");
					return new UploadFile(originalFileName, storeFileName);
				}
				else {
					log.info("CDN UPLOAD FAIL....");
				}
			}
			else {
				log.info("ftp 정보가 올바르지 않습니다.");
			}
			ftp.logout();
		}
		catch (Exception e) {
			log.info("ftp로그인 과정 에러");
			e.printStackTrace();
		}
		finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } 
                catch (Exception e) {
                	log.info("최종 ftp 연결 해제도 실패");
                    e.printStackTrace();
                }
            }
        }
		
    	return null;
    }
    
    
    /** 편의 메서드 **/
    public String getFullPath(String fileName){
        return cdn_url + fileName;
    }
    
    
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
