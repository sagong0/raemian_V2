package raemian.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import raemian.admin.domain.Notice;

@Mapper
public interface AdminNoticeMapper {
	List<Notice> findAll();
	
	List<Notice> findBySearchWord(String searchWord);
	
	List<Notice> findByCurrentPage(int pNo);
	List<Notice>findBySearchWordAndCurrentPage(Map<String,Object> maps);
}
