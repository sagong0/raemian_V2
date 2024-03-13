package raemian.common.repository;

import java.util.List;
import java.util.Map;

import raemian.admin.domain.Faq;
import raemian.admin.dto.FaqForm;

public interface FaqRepository {
	List<Faq> findByCurrentPage(int currentPage);
	
	List<Faq> findBySearchVal(String searchVal);
	
	int saveFaq(FaqForm faqForm);
	
	int deleteByFidx(int fidx);
	
	int countAll();
	
	List<Faq> findByCurrentPageAndSearchVal(Map<String, Object> maps);
}
