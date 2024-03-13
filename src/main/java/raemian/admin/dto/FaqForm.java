package raemian.admin.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class FaqForm {
	@NotEmpty(message = "질문 내용을 입력해주세요.")
	private String fquestion;
	@NotEmpty(message = "작성자를 입력해주세요.")
	private String fwriter;
	@NotEmpty(message = "답변 내용을 입력해주세요.")
	private String fanswer;
}
