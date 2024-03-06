package raemian.admin.repository;

import java.util.List;

import raemian.admin.domain.Notice;

public interface AdminNoticeRepository {
	List<Notice> findAll();
}
