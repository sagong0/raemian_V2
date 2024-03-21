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
	private UploadFile nfile2;
	
	// DB로 부터 읽어오는 용도.
	private String nfile;
	
	private int ncount;
	private LocalDate nindate;	
}