package raemian.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import raemian.client.domain.Member;
import raemian.common.Paging;
import raemian.common.dto.SearchDto;
import raemian.common.service.ClientMemberService;


@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class AdminMemberController {
	
	Logger log = LoggerFactory.getLogger(AdminMemberController.class);
	
	private final ClientMemberService memberService;
	
	
	@GetMapping("/")
	public String memberHome(
			@ModelAttribute SearchDto searchDto,
			@RequestParam(defaultValue = "1") int currentPage,
			Model model) {
		
		log.info("searchDto = {}", searchDto);
		
		List<Member> members = null;
		int total = 0;
		
		if(searchDto.getSearchVal() == null || searchDto.getSearchVal().isEmpty()) {
			members = memberService.findByCurrentPage(currentPage);
			total = memberService.countAll(searchDto);
		} else {
			members = memberService.findBySearchDtoAndCurrentPage(searchDto, currentPage);
			total = memberService.countAll(searchDto);
		}
		log.info("members Size = {}", members.size());

		model.addAttribute("members", members);
		model.addAttribute("list", new Paging(total, currentPage, 3, 5, null, null,null,members));
		return "admin/view/member_main";
	}
	
	@PostMapping("/delete")
	public String delMember(@RequestParam int midx, RedirectAttributes redirectAttributes) {
		int result = memberService.delete_member(midx);
		log.info("result ls {}", result);
		if(result <= 0) {
			redirectAttributes.addFlashAttribute("msg", "삭제 실패하였습니다.");
			return "admin/view/member_main";
		}
		// 성공로직
		redirectAttributes.addFlashAttribute("msg", "해당 계정을 성공적으로 삭제하였습니다.");
		return "redirect:/member/";
	}
}
