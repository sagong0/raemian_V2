package raemian.admin.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Notice;
import raemian.admin.dto.NoticeForm;
import raemian.admin.mapper.AdminNoticeMapper;
import raemian.common.repository.NoticeRepository;


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

	@Override
	public int saveNotice(NoticeForm noticeForm) {
		return noticeMapper.saveNotice(noticeForm);
	}

	@Override
	public int delNotice(int nidx) {
		return noticeMapper.delNotice(nidx);
	}

	@Override
	public Notice findByNidx(int nidx) {
	
		return noticeMapper.findByIdx(nidx);
	}


}
