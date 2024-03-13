package raemian.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import raemian.client.domain.Member;
import raemian.common.repository.ClientMemberRepository;

@Service
@RequiredArgsConstructor
public class ClientMemberService {
	private final ClientMemberRepository memberRepository;
	
	public List<Member> findAll(){
		return memberRepository.findAll();
	}
}
