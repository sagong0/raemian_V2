package raemian.common;

import java.util.List;

import raemian.admin.domain.Faq;
import raemian.admin.dto.FaqForm;

public interface FaqRepository {
	List<Faq> findByCurrentPage(int currentPage);
	
	int saveFaq(FaqForm faqForm);
	
	int deleteByFidx(int fidx);
	
	int countAll();
}
