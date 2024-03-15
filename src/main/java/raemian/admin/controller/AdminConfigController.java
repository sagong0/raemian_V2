package raemian.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.admin.domain.ConfigInfo;
import raemian.common.service.ConfigInfoService;

@Slf4j
@RequestMapping("/config")
@RequiredArgsConstructor
@Controller
public class AdminConfigController {
	
	private final ConfigInfoService configInfoService;
	
	@GetMapping("/")
	public String info_home() {
		List<ConfigInfo> configs = configInfoService.findAll();
		log.info("configs = {}", configs);
		return "admin/view/config/info_main";
	}
	
}
