package raemian.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import raemian.client.domain.Member;
import raemian.common.service.ClientMemberService;


@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class AdminMemberController {
	
	Logger log = LoggerFactory.getLogger(AdminMemberController.class);
	
	private final ClientMemberService memberService;
	
	
	@GetMapping("/")
	public String memberHome(Model model) {
		List<Member> members=memberService.findAll();
		log.info("members size is {}", members.size());
		return "admin/view/member_main";
	}
}
