package raemian.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Notice;
import raemian.admin.service.AdminNoticeService;

@RequestMapping("/notice")
@RequiredArgsConstructor
@Controller
public class AdminNoticeController {
	
	private final AdminNoticeService noticeService;
	
	@GetMapping("/")
	public String noticeMain() {
		List<Notice> notices = noticeService.findAllNotices();
		System.out.println(notices);
		return null;
	}
	
}
