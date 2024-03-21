package raemian.admin.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Notice;
import raemian.admin.dto.NoticeForm;
import raemian.admin.service.AdminNoticeService;
import raemian.common.Paging;
import raemian.common.UploadFile;
import raemian.common.service.CdnService;
import raemian.common.service.FileSaveService;

@RequestMapping("/notice")
@RequiredArgsConstructor
@Controller
public class AdminNoticeController {
	
	private final AdminNoticeService noticeService;
	private final CdnService cdnService;
	
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
		model.addAttribute("list", new Paging(total,currentPage,3,5,null,notices,null,null));
		return "admin/view/notice_main";
	}
	
	@GetMapping("/write")
	public String noticeWriteCreate() {
		return "admin/view/notice_write";
	}
	
	@PostMapping("/write")
	public String noticeSave(@ModelAttribute NoticeForm noticeForm, BindingResult bindingResult) throws IOException {
		
		if(bindingResult.hasErrors()) {
			return "admin/view/notice_write";
		}
		
		UploadFile uploadFile = null;
		int result = 0;
		
		long nfileSize = noticeForm.getNfile().getSize();
		// 첨부파일 없을떄
		if(nfileSize == 0 || nfileSize == 0L) {
			// 저장할 Notice 생성
			Notice notice = createNotice(noticeForm, uploadFile);
			
			result = noticeService.saveNotice(notice);
			
		} 
		else {
			// 첨부파일 있을떄 (CDN UPLOAD 해야함)
			uploadFile = cdnService.uploadFile(noticeForm.getNfile());
			log.info("uploadFile = {}", uploadFile);
			Notice notice = createNotice(noticeForm, uploadFile);
			result = noticeService.saveNotice(notice);
		}
		
		// 최종 성공로직 
		if(result <= 0) {
			return "admin/view/notice_write";
		} else {
			// 저장 성공
			return "redirect:/notice/";
		}
		
	}
	
	@GetMapping("/detail/{nidx}")
	public String noticeDetail(@PathVariable int nidx, Model model) {
		Notice findNotice = noticeService.findNoticeByNidx(nidx);
		log.info("findNotice = {}", findNotice);
		if(findNotice == null) {
			return "admin/view/notice_write";
		}
		// 조회수 up
		int countUpResult = noticeService.countUp(nidx);
		if(countUpResult <= 0) {
			return "admin/view/notice_main";
		}
		model.addAttribute("notice", findNotice);
		return "admin/view/notice_view";
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
	
	/**
	 * 첨부파일 다운로드
	 */
//	@GetMapping("/attach/{nidx}")
//	public ResponseEntity<Resource> downloadAttach(@PathVariable int nidx) throws MalformedURLException {
//		log.info("nidx = {}", nidx);
//		Notice findNotice = noticeService.findNoticeByNidx(nidx);
//		String fileName = findNotice.getNfile();
//		UrlResource resource = new UrlResource("file:" + cdnService.getFullPath(fileName));
//		
//		String encodedUploadFilename = UriUtils.encode(fileName, StandardCharsets.UTF_8);
//
//        // 다운로드시 헤더에 아래와같이 추가해줘야함 (규약)
//        String contentDisposition = "attachment; filename=\"" + encodedUploadFilename +"\"";
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition)
//                .body(resource);
//	}
	
	
	
	
	/** 편의 메소드 **/
	private boolean isSearchWordEmpty(String searchWord) {
	    return searchWord == null || searchWord.isEmpty();
	}
	
	private Notice createNotice(NoticeForm noticeForm, UploadFile uploadFile) {
		Notice notice= new Notice();
		notice.setNtitle(noticeForm.getNtitle());
		notice.setNwriter(noticeForm.getNwriter());
		notice.setNcontent(noticeForm.getNcontent());
		notice.setNfile2(uploadFile);
		return notice;
	}
}
