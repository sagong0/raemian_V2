package raemian.common.repository;

import java.util.List;
import java.util.Map;

import raemian.client.domain.Member;
import raemian.common.dto.SearchDto;

public interface ClientMemberRepository {
	List<Member> findAllByCurrentPage(int pNo);
	
	List<Member> findBySearchDtoAndCurrentPage(Map<String, Object> maps);
	
	int countAll();
	
	int countBySearchDto(SearchDto searchDto);
	
	int deleteByIdx(int midx);
}
