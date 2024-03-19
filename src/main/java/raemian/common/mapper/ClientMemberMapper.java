package raemian.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import raemian.admin.dto.AdminLoginDto;
import raemian.client.domain.Member;
import raemian.client.dto.JoinMemberForm;
import raemian.common.dto.SearchDto;

@Mapper
public interface ClientMemberMapper {
	List<Member> findAllByCurrentPage(int pNo);
	
	List<Member> findBySearchDtoAndCurrentPage(Map<String, Object> maps);
	
	Member findByMid(String mid);
	
	Member findByLoginDto(AdminLoginDto loginDto);
	
	int countAll();
	
	int countBySearchDto(SearchDto searchDto);
	
	int deleteByIdx(int midx);
	
	int insert_member(JoinMemberForm joinMemberForm);
}
