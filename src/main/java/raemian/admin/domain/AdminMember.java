package raemian.admin.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class AdminMember {
	private int aidx;
	private String aarea, adept, aname, aid,apw;
	private String aemail, atel, aposition;
	private int try_count;
	private String ause;
	private LocalDate aindate;
}
