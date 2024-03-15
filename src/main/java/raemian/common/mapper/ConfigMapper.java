package raemian.common.mapper;

import java.util.List;

import raemian.admin.domain.ConfigInfo;

public interface ConfigMapper {
	List<ConfigInfo> findAll();
}
