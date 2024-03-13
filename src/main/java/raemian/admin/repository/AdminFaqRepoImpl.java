package raemian.admin.repository;

import java.util.List;
import java.util.Map;

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
	public List<Faq> findByCurrentPage(int pNo) {
		return faqMapper.findByCurrentPage(pNo);
	}

	@Override
	public int saveFaq(FaqForm faqForm) {
		return faqMapper.saveFaq(faqForm);
	}

	@Override
	public int deleteByFidx(int fidx) {
		return faqMapper.deleteByFidx(fidx);
	}

	@Override
	public int countAll() {
		return faqMapper.countAll();
	}

	@Override
	public List<Faq> findByCurrentPageAndSearchVal(Map<String,Object> maps) {
		return faqMapper.findByCurrentPageAndSearchVal(maps);
	}

	@Override
	public List<Faq> findBySearchVal(String searchVal) {
		return faqMapper.findBySearchVal(searchVal);
	}
}
