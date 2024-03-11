package raemian.common;

import java.util.List;
import java.util.Map;

import raemian.admin.domain.Notice;
import raemian.admin.dto.NoticeForm;

public interface NoticeRepository {
	
	List<Notice> findAll();
	
	List<Notice> findBySearchWord(String searchWord);
	
	List<Notice> findNoticeByCurrentPage(int currentPage);
	
	List<Notice> findBySearchWordAndCurrentPage(Map<String, Object> maps);
	
	Notice saveNotice(NoticeForm noticeForm);
}
