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
import raemian.common.mapper.ClientMemberMapper;
import raemian.common.repository.ClientMemberRepository;
import raemian.common.repository.ClientMemberRepositoryImpl;
import raemian.common.repository.FaqRepository;
import raemian.common.repository.NoticeRepository;

@Configuration
@RequiredArgsConstructor
public class MybatisConfig{
	
	private final AdminMapper adminMapper;
	private final AdminNoticeMapper noticeMapper;
	private final AdminFaqMapper faqMapper;
//	private final ClientMemberMapper clientMemberMapper;
	
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
//	
//	@Bean
//	ClientMemberRepository clientMemberRepository() {
//		return new ClientMemberRepositoryImpl(clientMemberMapper);
//	}
}
