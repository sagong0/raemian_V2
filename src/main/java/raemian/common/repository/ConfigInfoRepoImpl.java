package raemian.common.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.ConfigInfo;
import raemian.admin.dto.ConfigInfoForm;
import raemian.common.mapper.ConfigMapper;


@Repository
@RequiredArgsConstructor
public class ConfigInfoRepoImpl implements ConfigInfoRepository{
	
	private final ConfigMapper configMapper;

	@Override
	public List<ConfigInfo> findAll() {
		return configMapper.findAll();
	}

	@Override
	public int insert_config(ConfigInfoForm configInfoForm) {
		return configMapper.insert_config(configInfoForm);
	}

	@Override
	public int delete_config(int aidx) {
		return configMapper.delete_config(aidx);
	}

	@Override
	public List<ConfigInfo> findByPrivate(String searchWord) {
		return configMapper.findByPrivate(searchWord);
	}
}
