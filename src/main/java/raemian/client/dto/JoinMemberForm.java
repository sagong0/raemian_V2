package raemian.client.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class JoinMemberForm {
	
	@NotEmpty(message = "사용자 이름을 입력해주세요.")
	private String mname;
	
	@NotEmpty(message = "사용자 아이디를 입력해주세요.")
	private String mid;
	
	@NotEmpty(message = "사용하실 비밀번호를 확인해주세요.")
	private String mpw;

	@Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호 형식이 아닙니다.")
	private String mtel;
	
	@Email(message = "올바른 이메일 형식을 사용해주세요.")
	private String memail;
	
	@NotEmpty
	private String mzipcode,mstreetaddr,mdetailaddr;
	
	@Pattern(regexp = "[YN]", message = "ckemail 은 Y or N 값 이어야 합니다.")
	private String ckemail;
	
	@Pattern(regexp = "[YN]", message = "cktel 은 Y or N 값 이어야 합니다.")
	private String cktel;
	
	@Pattern(regexp = "[YN]", message = "ckaddr 은 Y or N 값 이어야 합니다.")
	private String ckaddr;
	
	@Pattern(regexp = "[YN]", message = "cksms 은 Y or N 값 이어야 합니다.")
	private String cksms;
}
