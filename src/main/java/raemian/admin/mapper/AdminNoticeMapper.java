package raemian.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import raemian.admin.domain.Notice;

@Mapper
public interface AdminNoticeMapper {
	List<Notice> findAll();
}
