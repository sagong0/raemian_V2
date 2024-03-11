package raemian.common;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class UploadFile {
	
	private String uploadFileName;
	private String storeFileName;
	
	public UploadFile(String uploadFileName, String storeFileName) {
		this.uploadFileName = uploadFileName;
		this.storeFileName = storeFileName;
	}	
	
}
