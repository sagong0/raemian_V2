package raemian.client.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.admin.domain.ConfigInfo;
import raemian.client.domain.Member;
import raemian.client.dto.JoinMemberForm;
import raemian.common.service.ClientMemberService;
import raemian.common.service.ConfigInfoService;
import raemian.common.service.SmsApiService;

@Slf4j
@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientHomeController {
	
	private final ConfigInfoService configInfoService;
	private final ClientMemberService clientMemberService;
	private final SmsApiService smsService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<ConfigInfo> configs = configInfoService.findAll();
		log.info("configs = {}", configs);
		model.addAttribute("configs", configs);
		return "client/view/index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "client/view/login/login";
	}
	
	@GetMapping("/join")
	public String joinFormCreate() {
		return "client/view/login/join_member";
	}
	
	@PostMapping("/join")
	public String joinForm(@Valid @ModelAttribute JoinMemberForm joinMemberForm) {
		log.info("joinForm = {}", joinMemberForm);
		return "client/view/login/join_member";
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
	
	
	
}
