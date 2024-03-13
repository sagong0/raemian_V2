package raemian.common.repository;

import java.util.List;

import raemian.client.domain.Member;

public interface ClientMemberRepository {
	List<Member> findAll();
}
