package raemian.admin.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ConfigInfoForm {
	@NotEmpty
	private String atype,awriter;
	
    @Range(min = 0, max = 100, message = "주거전용 값은 0부터 100 사이어야 합니다.")
	private long aprivate;
    
    @Range(min = 0, max = 100, message = "주거공용 값은 0부터 100 사이어야 합니다.")
	private long apublic;
    
    @Range(min = 0, max = 100, message = "기타공용 값은 0부터 100 사이어야 합니다.")
	private long aetcpublic;
    
    @Range(min = 0, max = 100, message = "계약면적값은 0부터 100 사이어야 합니다.")
	private long acontractSize;
	
	@NotEmpty
	private String aimgUrl;
	
    @Pattern(regexp = "[ON]", message = "AUse 'O' or 'N' only")
	private String ause;
	
    @NotNull(message = "aorder를 입력하세요")
    @Digits(integer=10, fraction=0, message="숫자 형식으로 입력하세요")
    private long aorder;
}
