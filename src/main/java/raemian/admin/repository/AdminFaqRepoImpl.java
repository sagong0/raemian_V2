package raemian.admin.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Faq;
import raemian.admin.mapper.AdminFaqMapper;
import raemian.common.FaqRepository;


@Repository
@RequiredArgsConstructor
public class AdminFaqRepoImpl implements FaqRepository{
	
	private final AdminFaqMapper faqMapper;

	@Override
	public List<Faq> findAll() {
		return faqMapper.findAll();
	}

}
