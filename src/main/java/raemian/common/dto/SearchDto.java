package raemian.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SearchDto {
	private String searchType, searchVal;
}
