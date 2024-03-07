package raemian.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Notice;
import raemian.admin.service.AdminNoticeService;
import raemian.common.Paging;

@RequestMapping("/notice")
@RequiredArgsConstructor
@Controller
public class AdminNoticeController {
	
	private final AdminNoticeService noticeService;
	
	@GetMapping("/")
	public String noticeMain(
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchWord,
			Model model) {
		List<Notice> notices = null;
		int total = 0;
		
		// 검색어 없을 경우
		if(isSearchWordEmpty(searchWord)) {
			notices = noticeService.findNoticesByCurrentPage(currentPage);
		} else {
			// 검색어 있을 경우
			notices = noticeService.findBySearchWordAndCurrentPage(searchWord, currentPage);
		}
		
		total = noticeService.count_notices(searchWord);
		model.addAttribute("notices", notices);
		model.addAttribute("list", new Paging(total,currentPage,3,5,null,notices));
		return "admin/view/notice_main";
	}
	
	@GetMapping("/write")
	public String noticeWriteCreate() {
		return "admin/view/notice_write";
	}
	
	
	/** 편의 메소드 **/
	private boolean isSearchWordEmpty(String searchWord) {
	    return searchWord == null || searchWord.isEmpty();
	}
}
