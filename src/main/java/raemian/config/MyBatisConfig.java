package raemian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import raemian.admin.mapper.AdminFaqMapper;
import raemian.admin.mapper.AdminMapper;
import raemian.admin.mapper.AdminNoticeMapper;
import raemian.admin.repository.AdminFaqRepoImpl;
import raemian.admin.repository.AdminNoticeRepoImpl;
import raemian.admin.repository.AdminRepository;
import raemian.admin.repository.AdminRepositoryImpl;
import raemian.common.FaqRepository;
import raemian.common.NoticeRepository;

@Configuration
@RequiredArgsConstructor
public class MybatisConfig{
	
	private final AdminMapper adminMapper;
	private final AdminNoticeMapper noticeMapper;
	private final AdminFaqMapper faqMapper;
	
	@Bean
	AdminRepository adminRepository() {
		return new AdminRepositoryImpl(adminMapper);
	}
	
	@Bean
	NoticeRepository noticeRepository() {
		return new AdminNoticeRepoImpl(noticeMapper);
	}
	
	@Bean
	FaqRepository faqRepository() {
		return new AdminFaqRepoImpl(faqMapper);
	}
}
