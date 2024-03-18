package raemian.common.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.client.domain.Member;
import raemian.client.dto.JoinMemberForm;
import raemian.common.dto.SearchDto;
import raemian.common.mapper.ClientMemberMapper;


@Repository
@RequiredArgsConstructor
public class ClientMemberRepositoryImpl implements ClientMemberRepository{
	
	private final ClientMemberMapper memberMapper;

	@Override
	public List<Member> findAllByCurrentPage(int pNo) {
		return memberMapper.findAllByCurrentPage(pNo);
	}

	@Override
	public int countAll() {
		return memberMapper.countAll();
	}

	@Override
	public List<Member> findBySearchDtoAndCurrentPage(Map<String, Object> maps) {
		return memberMapper.findBySearchDtoAndCurrentPage(maps);
	}

	@Override
	public int countBySearchDto(SearchDto searchDto) {
		return memberMapper.countBySearchDto(searchDto);
	}

	@Override
	public int deleteByIdx(int midx) {
		return memberMapper.deleteByIdx(midx);
	}

	@Override
	public Optional<Member> findByMid(String mid) {
		return Optional.ofNullable(memberMapper.findByMid(mid));
	}

	@Override
	public int insert_member(JoinMemberForm joinMemberForm) {
		return memberMapper.insert_member(joinMemberForm);
	}

	

}
