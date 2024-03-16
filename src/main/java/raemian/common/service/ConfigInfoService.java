package raemian.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.ConfigInfo;
import raemian.admin.dto.ConfigInfoForm;
import raemian.common.repository.ConfigInfoRepository;

@Service
@RequiredArgsConstructor
public class ConfigInfoService {
	private final ConfigInfoRepository configRepository;
	
	public List<ConfigInfo> findAll(){
		return configRepository.findAll();
	}
	
	public int insert_config(ConfigInfoForm configInfoForm) {
		return configRepository.insert_config(configInfoForm);
	}
	
	public int delete_config(int aidx) {
		return configRepository.delete_config(aidx);
	}
	
	public List<ConfigInfo> findBySearch(String searchWord) {
		return configRepository.findByPrivate(searchWord);
	}
}
