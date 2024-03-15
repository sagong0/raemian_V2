package raemian.common.repository;

import java.util.List;

import raemian.admin.domain.ConfigInfo;

public interface ConfigInfoRepository {
	List<ConfigInfo> findAll();
}
