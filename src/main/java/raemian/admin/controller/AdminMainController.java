package raemian.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.admin.domain.AdminMember;
import raemian.admin.dto.StatusDto;
import raemian.admin.service.AdminService;
import raemian.client.domain.Member;
import raemian.client.domain.Reserve;
import raemian.common.Paging;
import raemian.common.dto.SearchDto;
import raemian.common.service.ClientMemberService;
import raemian.common.service.ReserveService;
import raemian.consts.SessionConst;


@Slf4j
@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class AdminMainController {
	private final AdminService adminService;
	private final ClientMemberService clientMemberService;
	private final ReserveService reserveService;
	
	@GetMapping("/")
	public String main(HttpServletRequest request, Model model) {
		List<Member> members = clientMemberService.findAll();
		List<Reserve> reserves = reserveService.findAll();
		model.addAttribute("members", members);
		model.addAttribute("reserves", reserves);
		return "admin/view/admin_main";
	}

	@GetMapping("/config")
	public String config_main(Model model, 
			@RequestParam(required = false) String aarea,
			@RequestParam(defaultValue = "1") int currentPage,
			@ModelAttribute SearchDto searchDto) {
		
		int total = 0;
		List<AdminMember> admins = null;
		
		if(aarea == null || aarea.isEmpty() || aarea.equals("") || aarea.equals("all")) {
			admins = adminService.findAdminListByCurrentPageAndSearchDto(currentPage, searchDto);
			log.info("*********");
			log.info("admins = {}", admins);
			total = adminService.count_admins(aarea,searchDto);
		} else {
			admins = adminService.findAdminsByAreaAndPage(aarea, currentPage);
			total = adminService.count_admins(aarea, searchDto);
		}
		
		model.addAttribute("admins", admins);
		model.addAttribute("list", new Paging(total, currentPage, 5, 5, admins, null,null,null));
		return "admin/view/config_main";
	}
	
	
	/**
	 * 근무중, 퇴직중 상태 AJAX 처리
	 */
	@ResponseBody
	@PostMapping("/status")
	public String adminStatusChange(@ModelAttribute StatusDto statusDto, HttpServletResponse response) {
		int result = adminService.modifyStatus(statusDto);
		if(result <= 0) {
			return "NO";
		}
		
		return "YES";
	}
}
