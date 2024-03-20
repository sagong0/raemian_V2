package raemian.client.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.admin.domain.ConfigInfo;
import raemian.admin.dto.AdminLoginDto;
import raemian.client.domain.Member;
import raemian.client.domain.Reserve;
import raemian.client.dto.JoinMemberForm;
import raemian.client.dto.ReserveForm;
import raemian.common.service.ClientMemberService;
import raemian.common.service.ConfigInfoService;
import raemian.common.service.ReserveService;
import raemian.common.service.SmsApiService;
import raemian.consts.SessionConst;

@Slf4j
@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientHomeController {
	
	private final ConfigInfoService configInfoService;
	private final ClientMemberService clientMemberService;
	private final SmsApiService smsService;
	private final ReserveService reserveService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<ConfigInfo> configs = configInfoService.findAll();
		log.info("configs = {}", configs);
		model.addAttribute("configs", configs);
		return "client/view/index";
	}
	
	@GetMapping("/login")
	public String loginFormCreate() {
		return "client/view/login/login";
	}
	
	@PostMapping("/login")
	public String loginForm(
			RedirectAttributes redirectAttributes,
			HttpServletRequest requset,
			@ModelAttribute AdminLoginDto loginDto) {

		Optional<Member> optioanlMember = clientMemberService.login(loginDto);
		if(!optioanlMember.isPresent()) {
			redirectAttributes.addFlashAttribute("msg", "계정을 확인해주세요.");
			return "redirect:/client/login";
		}
		
		HttpSession session = requset.getSession();
		session.setAttribute(SessionConst.LOGIN_MEMBER, optioanlMember.get());		
		return "redirect:/client/";
	}
	
	@GetMapping("/logOut")
	public String logOut(HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		redirectAttributes.addFlashAttribute("msg", "성공적으로 로그아웃 되었습니다.");
		return "redirect:/client/";
	}
	
	
	@GetMapping("/agree")
	public String agreePage() {
		return "client/view/login/join_agree";
	}
	
	@GetMapping("/join")
	public String joinFormCreate() {
		return "client/view/login/join_member";
	}
	
	@PostMapping("/join")
	public String joinForm(@Valid @ModelAttribute JoinMemberForm joinMemberForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes,
			Model model) {
		if(bindingResult.hasErrors()) {
	        model.addAttribute("errors", bindingResult.getAllErrors());
			return "client/view/login/join_member";
		}
		// 성공로직
		int result = clientMemberService.insert_member(joinMemberForm);
		if(result < 0) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "client/view/login/join_member";
		}
		redirectAttributes.addFlashAttribute("msg", "성공적으로 회원가입 되셨습니다. 로그인 후 사용해주세요.");
		return "redirect:/client/login/";
	}
	
	@ResponseBody
	@PostMapping("/checkId")
	public String idCheck(@RequestBody String mid) {
		log.info("mid = {}", mid);
		Optional<Member> optionalMember = clientMemberService.findByMid(mid);
		if(optionalMember.isPresent()) {
			return "nouse";
		} 
		return "canuse";
	}
	
	@ResponseBody
	@PostMapping("/smsVerification.do")
	public String smsApiService(@RequestParam int smsNo, @RequestParam String mtel) {
		String sign = "";
		try {
			sign = smsService.smsApiService(smsNo, mtel);
			log.info("sign = {}", sign);
		} catch (Exception e) {
			log.info("fail!!!!!!!!");
			e.printStackTrace();
		}
		return sign;
	}
	
	/**
	 * 예약 페이지 
	 */
	@GetMapping("/reserve")
	public String reserveFormCreate() {
		return "client/view/reservation/reserve_in";
	}
	
	@PostMapping("/reserve")
	public String reserveForm(@Valid @ModelAttribute ReserveForm reserveForm,
			HttpServletResponse response,
			BindingResult bindingResult,
			Model model) throws IOException {
		/** 예약일자 GLOBAL Validation **/
		validateRdate(reserveForm, bindingResult);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors",bindingResult.getAllErrors());
			return "client/view/reservation/reserve_in";
		}
		
		// 성공로직
		return reserveService.insert_reserve(reserveForm,response);
	}

	/**
	 * 예약 확인 페이지
	 * (예약 수정 페이지)
	 * @throws IOException 
	 */
	@GetMapping("/reserve/modify")
	public String reserveModifyFormCreate(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
		Map<String, String> sessionInfoMap = extractSessionInfo(request);
		Reserve reserve = reserveService.findBySessionInfo(sessionInfoMap,response);
		
		model.addAttribute("reserve", reserve);
		return "client/view/reservation/reservation_ck";
	}

	
	
	
	/**
	 * 편의 메소드 
	 */
	private void validateRdate(ReserveForm reserveForm, BindingResult bindingResult) {
		String today = LocalDate.now().toString();
		int p_today = Integer.valueOf(today.replaceAll("-", ""));
		
		int rdate = Integer.valueOf(reserveForm.getRdate().replaceAll("-", ""));
		
		if(rdate < p_today) {
			bindingResult.reject("rdateErr", "예약일자는 오늘 이후 날짜로 선택해주세요.");
		}
	}
	
	private Map<String,String> extractSessionInfo(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Member member = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);
		String mid = member.getMid();
		String mname = member.getMname();
		
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("mid", mid);
		maps.put("mname", mname);
		return maps;
	}
}
