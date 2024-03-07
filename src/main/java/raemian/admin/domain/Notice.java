package raemian.admin.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class Notice {
	private int nidx;
	private String ntitle, nwriter, ncontent, nfile;
	private int count;
	private LocalDate nindate;
}