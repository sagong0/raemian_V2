package raemian.common.mapper;

import java.util.List;

import raemian.admin.domain.ConfigInfo;
import raemian.admin.dto.ConfigInfoForm;

public interface ConfigMapper {
	List<ConfigInfo> findAll();
	
	int insert_config(ConfigInfoForm configInfoForm);
	
	int delete_config(int aidx);
	
	List<ConfigInfo> findByPrivate(String SearchWord);
}
