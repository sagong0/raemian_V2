package raemian.admin.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Faq;
import raemian.admin.dto.FaqForm;
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

	@Override
	public int saveFaq(FaqForm faqForm) {
		return faqMapper.saveFaq(faqForm);
	}

	@Override
	public int deleteByFidx(int fidx) {
		return faqMapper.deleteByFidx(fidx);
	}
}
