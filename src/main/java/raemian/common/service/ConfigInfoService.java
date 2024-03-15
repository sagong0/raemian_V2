package raemian.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.ConfigInfo;
import raemian.common.repository.ConfigInfoRepository;

@Service
@RequiredArgsConstructor
public class ConfigInfoService {
	private final ConfigInfoRepository configRepository;
	
	public List<ConfigInfo> findAll(){
		return configRepository.findAll();
	}
}
