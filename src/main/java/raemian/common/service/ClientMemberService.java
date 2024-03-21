package raemian.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.admin.dto.AdminLoginDto;
import raemian.client.domain.Member;
import raemian.client.dto.JoinMemberForm;
import raemian.common.dto.SearchDto;
import raemian.common.repository.ClientMemberRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientMemberService {
	private final ClientMemberRepository memberRepository;
	
	public List<Member> findAll(){
		return memberRepository.findAll();
	}
	
	
	
	public List<Member> findByCurrentPage(int currentPage){
		int pNo = (currentPage-1) * 3;
		return memberRepository.findAllByCurrentPage(pNo);
	}
	
	public int countAll(SearchDto searchDto) {
		if(searchDto.getSearchVal() == null || searchDto.getSearchVal().isEmpty()) {
			return memberRepository.countAll();
		}
		
		return memberRepository.countBySearchDto(searchDto);
	}
	
	
	public List<Member> findBySearchDtoAndCurrentPage(SearchDto searchDto, int currentPage){
		int pNo = (currentPage-1) * 3;
		Map<String, Object> maps = new HashMap<>();
		maps.put("searchDto", searchDto);
		maps.put("pNo", pNo);
		
		return memberRepository.findBySearchDtoAndCurrentPage(maps);
	}
	
	public int delete_member(int midx) {
		return memberRepository.deleteByIdx(midx);
	}
	
	
	/**
	 * ID 중복 체크 시 
	 * 해당 입력 아이디로 Member 찾기
	 */
	public Optional<Member> findByMid(String mid) {
		return memberRepository.findByMid(mid);
	}
	
	/**
	 * 회원가입 (INSERT)
	 */
	public int insert_member(JoinMemberForm joinMemberForm) {
		return memberRepository.insert_member(joinMemberForm);
	}
	
	/**
	 * LOGIN PART
	 */
	public Optional<Member> login(AdminLoginDto loginDto) {
		return memberRepository.findByLoginDto(loginDto);
	}
	
	
}
