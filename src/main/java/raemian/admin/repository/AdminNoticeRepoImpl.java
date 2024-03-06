package raemian.admin.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Notice;
import raemian.admin.mapper.AdminNoticeMapper;


@Repository
@RequiredArgsConstructor
public class AdminNoticeRepoImpl implements AdminNoticeRepository{
	
	private final AdminNoticeMapper noticeMapper;

	@Override
	public List<Notice> findAll() {
		return noticeMapper.findAll();
	}

}
