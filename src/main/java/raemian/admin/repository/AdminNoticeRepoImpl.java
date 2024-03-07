package raemian.admin.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Notice;
import raemian.admin.mapper.AdminNoticeMapper;
import raemian.common.NoticeRepository;


@Repository
@RequiredArgsConstructor
public class AdminNoticeRepoImpl implements NoticeRepository{
	
	private final AdminNoticeMapper noticeMapper;

	@Override
	public List<Notice> findAll() {
		return noticeMapper.findAll();
	}
	
	@Override
	public List<Notice> findNoticeByCurrentPage(int currentPage) {
		return noticeMapper.findByCurrentPage(currentPage);
	}

	@Override
	public List<Notice> findBySearchWord(String searchWord) {
		return noticeMapper.findBySearchWord(searchWord);
	}

	@Override
	public List<Notice> findBySearchWordAndCurrentPage(Map<String, Object> maps) {
		
		return noticeMapper.findBySearchWordAndCurrentPage(maps);
	}

}
