package raemian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import raemian.admin.mapper.AdminMapper;
import raemian.admin.mapper.AdminNoticeMapper;
import raemian.admin.repository.AdminNoticeRepoImpl;
import raemian.admin.repository.AdminNoticeRepository;
import raemian.admin.repository.AdminRepository;
import raemian.admin.repository.AdminRepositoryImpl;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
	
	private final AdminMapper adminMapper;
	private final AdminNoticeMapper noticeMapper;
	
	@Bean
	AdminRepository adminRepository() {
		return new AdminRepositoryImpl(adminMapper);
	}
	
	@Bean
	AdminNoticeRepository noticeRepository() {
		return new AdminNoticeRepoImpl(noticeMapper);
	}
	
}
