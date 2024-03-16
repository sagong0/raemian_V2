package raemian.common.repository;

import java.util.List;

import raemian.admin.domain.ConfigInfo;
import raemian.admin.dto.ConfigInfoForm;

public interface ConfigInfoRepository {
	List<ConfigInfo> findAll();
	
	int insert_config(ConfigInfoForm configInfoForm);
	
}
