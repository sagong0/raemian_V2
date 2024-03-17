package raemian.common.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import raemian.client.domain.Member;
import raemian.common.dto.SearchDto;

public interface ClientMemberRepository {
	List<Member> findAllByCurrentPage(int pNo);
	
	List<Member> findBySearchDtoAndCurrentPage(Map<String, Object> maps);
	
	Optional<Member> findByMid(String mid);
	
	int countAll();
	
	int countBySearchDto(SearchDto searchDto);
	
	int deleteByIdx(int midx);
}
