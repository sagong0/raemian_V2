package raemian.common.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import raemian.admin.dto.AdminLoginDto;
import raemian.client.domain.Member;
import raemian.client.dto.JoinMemberForm;
import raemian.common.dto.SearchDto;

public interface ClientMemberRepository {
	List<Member> findAll();
	
	List<Member> findAllByCurrentPage(int pNo);
	
	List<Member> findBySearchDtoAndCurrentPage(Map<String, Object> maps);
	
	Optional<Member> findByMid(String mid);
	
	Optional<Member> findByLoginDto(AdminLoginDto loginDto);
	
	int countAll();
	
	int countBySearchDto(SearchDto searchDto);
	
	int deleteByIdx(int midx);
	
	int insert_member(JoinMemberForm joinMemberForm);
}
