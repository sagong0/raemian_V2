package raemian.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Notice;
import raemian.admin.repository.AdminNoticeRepository;

@Service
@RequiredArgsConstructor
public class AdminNoticeService {
	
	private final AdminNoticeRepository noticeRepository;
	
	public List<Notice> findAllNotices(){
		return noticeRepository.findAll();
	};
}
