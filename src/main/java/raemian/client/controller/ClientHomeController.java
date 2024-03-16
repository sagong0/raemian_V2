package raemian.client.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.admin.domain.ConfigInfo;
import raemian.common.service.ConfigInfoService;

@Slf4j
@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientHomeController {
	
	private final ConfigInfoService configInfoService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<ConfigInfo> configs = configInfoService.findAll();
		log.info("configs = {}", configs);
		model.addAttribute("configs", configs);
		return "client/view/index";
	}
	
}
