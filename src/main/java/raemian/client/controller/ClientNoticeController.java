package raemian.client.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.admin.domain.Notice;
import raemian.admin.service.AdminNoticeService;
import raemian.common.Paging;

@Slf4j
@Controller
@RequestMapping("/notices")
@RequiredArgsConstructor
public class ClientNoticeController {
	
	private final AdminNoticeService noticeService;
	
	@GetMapping("/")
	public String mainNotices(
			@RequestParam(required = false) String searchWord,
			@RequestParam(defaultValue = "1") int currentPage,
			Model model) {
		log.info("saerchWord = {} ", searchWord);
		
		List<Notice> notices = null;
		int total = 0;
		
		if(searchWord == null ||searchWord.isEmpty()) {
			notices = noticeService.findNoticesByCurrentPage(currentPage);
		} else {
			notices = noticeService.findBySearchWordAndCurrentPage(searchWord, currentPage);
		}
		total = noticeService.count_notices(searchWord);
		
		model.addAttribute("notices", notices);
		model.addAttribute("list", new Paging(total, currentPage, 3, 5, null, notices, null, null));
		
		return "client/view/notice/notice";
	}
}
