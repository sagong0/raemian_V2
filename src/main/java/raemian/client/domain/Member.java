package raemian.client.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Member {
	private int midx;
	private String mname, mid, mpw;
	private String mtel;
	private String meail, mzipcode,mstreetaddr,mdetailaddr;
	private String ckemail,cktel,ckaddr,cksms;
	private LocalDate mindate;
	private String muse;
}