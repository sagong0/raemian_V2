package raemian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import raemian.admin.mapper.AdminMapper;
import raemian.admin.repository.AdminRepository;
import raemian.admin.repository.AdminRepositoryImpl;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
	
	private final AdminMapper adminMapper;
	
	@Bean
	AdminRepository adminRepository() {
		return new AdminRepositoryImpl(adminMapper);
	}
	
}
