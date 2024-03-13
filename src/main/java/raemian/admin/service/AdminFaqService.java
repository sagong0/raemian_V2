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
	
	public List<Faq> findAll(){
		return faqRepository.findAll();
	}
	
	public int saveFaq(FaqForm faqForm){
		return faqRepository.saveFaq(faqForm);
	}
	
	public int deleteByFidx(int fidx) {
		return faqRepository.deleteByFidx(fidx);
	}
}
