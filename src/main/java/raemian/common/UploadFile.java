package raemian.common;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class UploadFile {
	
	// 클라이언트 업로드 명
	private String uploadFileName;
	// 저장할 파일 명
	private String storeFileName;
	
	public UploadFile(String uploadFileName, String storeFileName) {
		this.uploadFileName = uploadFileName;
		this.storeFileName = storeFileName;
	}	
	
}
