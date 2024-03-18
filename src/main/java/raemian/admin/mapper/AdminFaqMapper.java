package raemian.admin.mapper;

import java.util.List;
import java.util.Map;

import raemian.admin.domain.Faq;
import raemian.admin.dto.FaqForm;

public interface AdminFaqMapper {
	
	List<Faq> findByCurrentPage(int pNo);
	
	List<Faq> findAll();
	
	int saveFaq(FaqForm faqForm);
	
	int deleteByFidx(int fidx);
	
	int countAll();
	
	List<Faq> findByCurrentPageAndSearchVal(Map<String,Object> maps);
	
	List<Faq> findBySearchVal(String searchVal);
}
