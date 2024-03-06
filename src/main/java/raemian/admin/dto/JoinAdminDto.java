package raemian.admin.dto;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class JoinAdminDto {
	
	private String aarea;
	private String aname;
	
	@Length(min = 6, message = "6자 이상의 아이디를 입력해주세요.")
	private String aid;
	
	private String adept, aposition,apw1, atel;
	
	@Email(message = "이메일 형식을 확인해주세요.")
	private String aemail;
	
}
