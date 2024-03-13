package raemian.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Faq;
import raemian.admin.dto.FaqForm;
import raemian.common.FaqRepository;

@Service
@RequiredArgsConstructor
public class AdminFaqService {
	
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
	
	public int countAll() {
		return faqRepository.countAll();
	}
}
