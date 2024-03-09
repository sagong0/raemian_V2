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
import raemian.admin.domain.AdminMember;
import raemian.admin.dto.StatusDto;
import raemian.admin.service.AdminService;
import raemian.common.Paging;
import raemian.consts.SessionConst;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class AdminMainController {
	private final AdminService adminService;
	
	@GetMapping("/")
	public String main(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object asdf = session.getAttribute(SessionConst.LOGIN_MEMBER);;		
		System.out.println("session is " + asdf);
		return "admin/view/admin_main";
	}

	@GetMapping("/config")
	public String config_main(Model model, 
			@RequestParam(required = false) String aarea,
			@RequestParam(defaultValue = "1") int currentPage) {
		/**
		 * 1 -> 0,5
		 * 2 -> 5,5
		 * 3 -> 10,5
		 * 4 -> 15,5
		 * n -> (n-1) * 5
		 */
		int total = 0;
		List<AdminMember> admins = null;
		
		if(aarea == null || aarea.isEmpty() || aarea.equals("") || aarea.equals("all")) {
			admins = adminService.findAdminListByCurrentPage(currentPage);
			total = adminService.count_admins(aarea);
		} else {
			admins = adminService.findAdminsByAreaAndPage(aarea, currentPage);
			total = adminService.count_admins(aarea);
		}
		
		model.addAttribute("admins", admins);
		model.addAttribute("list", new Paging(total, currentPage, 5, 5, admins, null));
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
