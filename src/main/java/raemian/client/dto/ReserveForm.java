package raemian.client.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ReserveForm {
	@NotEmpty(message = "아이디를 입력하세요.")
    private String rid;
    
    @NotEmpty(message = "고객명을 입력하세요.")
    private String rname;
    
    @NotEmpty(message = "예약일자을 입력하세요.")
    private String rdate;
    
    @NotEmpty(message = "예약시간을 입력하세요.")
    private String rtime;
    
    @NotEmpty(message = "휴대전화번호를 입력하세요.")
    private String rtel;
    
    @NotEmpty(message = "인원수를 선택하세요.")
    private String rcount;
}