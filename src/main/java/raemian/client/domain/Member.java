package raemian.client.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Member {
	private int midx;
	
	private String mname;
	
	private String mid;
	
	private String mpw;
	
	private String mtel;
	
	private String memail;
	
	private String mzipcode,mstreetaddr,mdetailaddr;
	
	private String ckemail;
	
	private String cktel;
	
	private String ckaddr;
	
	private String cksms;
	
	private LocalDate mindate;
	
	
	private String muse;
}