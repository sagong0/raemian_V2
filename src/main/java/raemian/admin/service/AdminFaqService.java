package raemian.admin.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Faq;
import raemian.admin.dto.FaqForm;
import raemian.common.repository.FaqRepository;

@Service
@RequiredArgsConstructor
public class AdminFaqService {
	Logger log = LoggerFactory.getLogger(AdminFaqService.class);
	
	private final FaqRepository faqRepository;
	
	public List<Faq> findByCurrentPage(int currentPage){
		/**
		 * 1 ->  0,5
		 * 2 ->  5,5
		 * 3 ->  10,5
		 * n -> (n-1) * 5
		 */
		int pNo = (currentPage -1) * 5;
		return faqRepository.findByCurrentPage(pNo);
	}
	
	public int saveFaq(FaqForm faqForm){
		return faqRepository.saveFaq(faqForm);
	}
	
	public int deleteByFidx(int fidx) {
		return faqRepository.deleteByFidx(fidx);
	}
	
	public int countAll(String searchVal) {
		if(searchVal == null || searchVal.isEmpty()) {
			return faqRepository.countAll();
		}
		
		return faqRepository.findBySearchVal(searchVal).size();
	}
	
	public List<Faq> findByCurrentPageAndSearchVal(int currentPage,String searchVal){
		HashMap<String, Object> maps = new HashMap<>();
		
		int pNo = (currentPage -1) * 5;
		maps.put("pNo", pNo);
		maps.put("searchVal", searchVal);
		return faqRepository.findByCurrentPageAndSearchVal(maps);
	}
}
