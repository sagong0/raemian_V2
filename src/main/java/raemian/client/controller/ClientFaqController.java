package raemian.client.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.admin.domain.Faq;
import raemian.admin.service.AdminFaqService;

@Slf4j
@RequestMapping("/faqs")
@Controller
@RequiredArgsConstructor
public class ClientFaqController {
	
	private final AdminFaqService faqService;
	
	@GetMapping("/")
	public String faqPage(Model model) {
		List<Faq> faqs = faqService.findAll();
		model.addAttribute("faqs", faqs);
		return "client/view/faq/faq";
	}
	
}
