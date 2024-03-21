package raemian.admin.dto;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class NoticeForm {
	@NotEmpty(message = "작성 양식을 확인해주세요.")
	private String ntitle, nwriter, ncontent;
	private MultipartFile nfile;
}
