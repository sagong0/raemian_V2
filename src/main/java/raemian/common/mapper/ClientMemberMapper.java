package raemian.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import raemian.client.domain.Member;
import raemian.common.dto.SearchDto;

@Mapper
public interface ClientMemberMapper {
	List<Member> findAllByCurrentPage(int pNo);
	
	List<Member> findBySearchDtoAndCurrentPage(Map<String, Object> maps);
	
	int countAll();
	
	int countBySearchDto(SearchDto searchDto);
	
	int deleteByIdx(int midx);
}
