package raemian.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Faq;
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
		log.info("called here");
		return "admin/view/faq/faq_write";
	}
	
}
