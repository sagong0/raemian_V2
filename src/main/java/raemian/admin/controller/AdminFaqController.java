package raemian.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Faq;
import raemian.admin.dto.FaqForm;
import raemian.admin.service.AdminFaqService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/faq")
public class AdminFaqController {
	Logger log = LoggerFactory.getLogger(AdminFaqController.class);
	
	private final AdminFaqService faqService;
	
	@GetMapping("/")
	public String faq_home(Model model) {
		List<Faq> faqs = faqService.findAll();
		model.addAttribute("faqs", faqs);
		return "admin/view/faq/faq_main";
	}
	
	@GetMapping("/write")
	public String faqWriteFormCreate() {
		return "admin/view/faq/faq_write";
	}
	
	@PostMapping("/write")
	public String faqWriteForm(@ModelAttribute FaqForm faqForm, 
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			return "admin/view/faq/faq_write";
		}
		
		
		int result = faqService.saveFaq(faqForm);
		if(result < 0) {
			redirectAttributes.addFlashAttribute("failMsg", "등록에 실패하였습니다.");
			return "admin/view/faq/faq_write";
		}
		//성공로직
		redirectAttributes.addFlashAttribute("successMsg", "등록되었습니다.");
		return "redirect:/faq/";
	}
	
	
	@PostMapping("/delete")
	public String deleteFaq(@RequestParam int fidx, RedirectAttributes redirectAttributes) {
		log.info("**************");
		int result = faqService.deleteByFidx(fidx);
		if(result < 0) {
			redirectAttributes.addFlashAttribute("failMsg", "삭제에 실패하였습니다.");
			return "admin/view/faq/faq_main";
		}
		// 성공로직
		redirectAttributes.addFlashAttribute("successMsg","삭제되었습니다.");
		return "redirect:/faq/";
	}
	
}
