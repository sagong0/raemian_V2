package raemian.client.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Reserve {
	private int ridx;
	private String rid,rname;
	private LocalDate rdate;
	private LocalTime rtime;
	private String rtel;
	private int rcount;
	private int rchance;
}
