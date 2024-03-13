package raemian.admin.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import raemian.common.UploadFile;


@Getter @Setter @ToString
public class Notice {
	private int nidx;
	private String ntitle, nwriter, ncontent;
	private String nfile;
	private String originalFileName;
	private String storeFileName;
	private int ncount;
	private LocalDate nindate;
	
	
}