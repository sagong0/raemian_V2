package raemian.admin.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Faq {
	private int idx;
	private String fquestion, fanswer, fwriter;
	private LocalDate findate;
}
