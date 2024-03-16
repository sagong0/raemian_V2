package raemian.admin.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ConfigInfoForm {
	@NotEmpty
	private String atype,awriter;
	
	@Min(value=0,message = "0이상의 숫자를 입력해주세요.")
	@Max(value=100, message="100이하의 숫자만 입력가능합니다.")
	private long aprivate;
	private long apublic;
	private long aetcpublic;
	private long acontractSize;
	
	@NotEmpty
	private String aimgUrl, ause;
	
	@Min(value=0,message = "0이상의 숫자를 입력해주세요.")
	@Max(value=100, message="100이하의 숫자만 입력가능합니다.")
    private long aorder;
}
