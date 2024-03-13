package raemian.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import raemian.client.domain.Member;

@Mapper
public interface ClientMemberMapper {
	List<Member> findAll();
}
