package raemian.client.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Notice;
import raemian.admin.service.AdminNoticeService;

@Controller
@RequestMapping("/notices")
@RequiredArgsConstructor
public class ClientNoticeController {
	
	private final AdminNoticeService noticeService;
	
	@GetMapping("/")
	public String mainNotices(Model model) {
		List<Notice> notices = noticeService.findAllNotices();
		model.addAttribute("notices", notices);
		
		return "client/view/notice/notice";
	}
}
