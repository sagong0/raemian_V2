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
	private UploadFile nfile;
	private int ncount;
	private LocalDate nindate;
	
	public Notice(String ntitle, String nwriter, String ncontent, UploadFile nfile, int ncount, LocalDate nindate) {	
		this.ntitle = ntitle;
		this.nwriter = nwriter;
		this.ncontent = ncontent;
		this.nfile = nfile;
		this.ncount = ncount;
		this.nindate = nindate;
	}
	
	
}