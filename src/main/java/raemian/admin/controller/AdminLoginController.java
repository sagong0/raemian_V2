package raemian.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.AdminMember;
import raemian.admin.dto.AdminLoginDto;
import raemian.admin.dto.JoinAdminDto;
import raemian.admin.service.AdminService;
import raemian.consts.SessionConst;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminLoginController {
	private final AdminService adminService;
	

	@GetMapping("/")
	public String home() {
		return "admin/view/index";
	}

	@GetMapping("/join")
	public String adminCreateForm() {
		return "admin/view/admin_join_form";
	}

	/**
	 * 회원가입 클릭시
	 */
	@PostMapping("/join")
	public String adminCreate(@Validated @ModelAttribute JoinAdminDto joinAdminDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "admin/view/admin_join_form";
		}
		// 성공 로직 !!!
		return adminService.joinAdmin(joinAdminDto, redirectAttributes);
	}

	/**
	 * ID 중복체크
	 */
	@PostMapping("/id_ck")
	@ResponseBody
	public String check_admin_id(@RequestBody String id) {
		return adminService.findAdmin(id);
	}

	// ADMIN 로그인 처리
	@PostMapping("/login")
	public String adminLogin(@Validated @ModelAttribute AdminLoginDto loginDto, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		response.setContentType("text/html; charset=utf-8;");

		if (bindingResult.hasErrors()) {
			return "admin/view/index";
		}

		Optional<AdminMember> adminOptional = adminService.admin_login(loginDto);

		if (!adminOptional.isPresent()) {
			Optional<AdminMember> justIdCorrectAdmin = adminService.findAdminById(loginDto.getAid());
			
			// 로그인 실패 : 아이디만 맞는 경우
			if (justIdCorrectAdmin.isPresent()) {
				
				/**
				 *  해당 로그인 시도 아이디 try_count 5 일때
				 *  Ause => N 으로 변경
				 */
				if(justIdCorrectAdmin.get().getTry_count() >= 5) {
					adminService.updateAuse(justIdCorrectAdmin.get().getAid());
				}
				
				// 해당 로그인 시도 아이디 try_count +1 처리
				adminService.updateTryCount(justIdCorrectAdmin.get().getAid());
				model.addAttribute("loginFail", "아이디 또는 패스워드를 확인해주세요."
						+ "<br> 5회 이상 로그인 실패시 계정이 정지됩니다."
						+ "<br> 계정 정지시 관리자에게 문의해 주세요.");
				return "admin/view/index";				
			}

			// 로그인 실패 : 아이디, 비번 다 틀린 경우
			model.addAttribute("loginFail", "아이디 또는 패스워드를 확인해주세요.<br>"
					+ " 5회 이상 로그인 실패시 계정이 정지됩니다.<br>"
					+ " 계정 정지시 관리자에게 문의해 주세요.");
			return "admin/view/index";
		}

		/**
		 * 아디,비번 맞았지만... 해당 계정 정지 상태 일 때
		 */
	    if (adminOptional.get().getAuse().equals("N")) {
	        model.addAttribute("loginFail", "해당 계정은 5회 이상 로그인 실패로 정지 되었습니다."
	                + "관리자에게 문의해 주세요.");
	        return "admin/view/index";
	    }

		// 성공로직
	    HttpSession session = request.getSession();
	    session.setAttribute(SessionConst.LOGIN_MEMBER, adminOptional.get());
		return "redirect:/main/";
	}

	@GetMapping("/logout")
	public String adminLogOut(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/admin/";
	}

}
