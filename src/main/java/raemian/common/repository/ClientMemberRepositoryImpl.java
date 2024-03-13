package raemian.common.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.client.domain.Member;
import raemian.common.mapper.ClientMemberMapper;


@Repository
@RequiredArgsConstructor
public class ClientMemberRepositoryImpl implements ClientMemberRepository{
	
	private final ClientMemberMapper memberMapper;

	@Override
	public List<Member> findAll() {
		return memberMapper.findAll();
	}

}
