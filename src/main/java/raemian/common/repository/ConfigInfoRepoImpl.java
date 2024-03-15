package raemian.common.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.ConfigInfo;
import raemian.common.mapper.ConfigMapper;


@Repository
@RequiredArgsConstructor
public class ConfigInfoRepoImpl implements ConfigInfoRepository{
	
	private final ConfigMapper configMapper;

	@Override
	public List<ConfigInfo> findAll() {
		return configMapper.findAll();
	}
}
