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
/*
nidx     | int(11)      | NO   | PRI | NULL              | auto_increment |
| ntitle   | varchar(255) | NO   |     | NULL              |                |
| nwriter  | varchar(100) | NO   |     | NULL              |                |
| ncontent | text         | NO   |     | NULL              |                |
| nfile    | varchar(255) | YES  |     | NULL              |                |
| ncount   | int(11)      | NO   |     | 0                 |                |
| nindate
*/