package raemian.admin.mapper;

import java.util.List;

import raemian.admin.domain.Faq;
import raemian.admin.dto.FaqForm;

public interface AdminFaqMapper {
	
	List<Faq> findAll();
	
	int saveFaq(FaqForm faqForm);
	
	int deleteByFidx(int fidx);
}
