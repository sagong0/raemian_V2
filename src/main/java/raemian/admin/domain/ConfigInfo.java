package raemian.admin.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class ConfigInfo {
	private int aidx;
	private String atype,awriter;
	private double aprivate,apublic,aetcpublic,acontractSize;
	private String aimgUrl, ause;
	private int aorder;
	private LocalDate aindate;
}