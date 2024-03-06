package raemian.admin.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class AdminLoginDto {
	@NotEmpty(message = "아이디를 입력해주세요.")
	private String aid;
	
	@Size(min = 6, message = "비밀번호는 최소 6자 이상 입력해주세요.")
	private String apw;
}
