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
import raemian.admin.domain.Notice;
import raemian.admin.dto.NoticeForm;
import raemian.admin.service.AdminNoticeService;
import raemian.common.Paging;

@RequestMapping("/notice")
@RequiredArgsConstructor
@Controller
public class AdminNoticeController {
	
	private final AdminNoticeService noticeService;
	
	Logger log = LoggerFactory.getLogger(AdminNoticeController.class);
	
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
	
	@PostMapping("/write")
	public String noticeSave(@ModelAttribute NoticeForm noticeForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "admin/view/notice_write";
		}
		// 성공 로직
		int result = noticeService.saveNotice(noticeForm);
		if(result < 0) {
			return "admin/view/notice_write";
		}
		return "redirect:/notice/";
	}
	
	@PostMapping("/delete")
	public String del_notice(@RequestParam int nidx, RedirectAttributes redirectAttributes) {
		try {
			noticeService.delete_notice(nidx);
			redirectAttributes.addFlashAttribute("successMsg", "성공적으로 삭제되었습니다.");
		} catch(Exception e) {
			redirectAttributes.addFlashAttribute("failMsg", "삭제에 실패하였습니다.");
			return "admin/view/notice/write";
		}
		return "redirect:/notice/";
	}
	
	
	
	
	/** 편의 메소드 **/
	private boolean isSearchWordEmpty(String searchWord) {
	    return searchWord == null || searchWord.isEmpty();
	}
}
