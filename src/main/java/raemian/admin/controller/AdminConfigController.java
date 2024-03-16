package raemian.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.admin.domain.ConfigInfo;
import raemian.admin.dto.ConfigInfoForm;
import raemian.common.service.ConfigInfoService;

@Slf4j
@RequestMapping("/config")
@RequiredArgsConstructor
@Controller
public class AdminConfigController {
	
	private final ConfigInfoService configInfoService;
	
	@GetMapping("/")
	public String info_home(Model model) {
		List<ConfigInfo> configs = configInfoService.findAll();
		
		model.addAttribute("configs", configs);
		return "admin/view/config/info_main";
	}
	
	@GetMapping("/write")
	public String newInfoFormCreate() {
		return "admin/view/config/info_write";
	}
	
	@PostMapping("/write")
	public String newInfoForm(@Valid @ModelAttribute ConfigInfoForm infoForm, BindingResult bindingResult,Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult);
			return "admin/view/config/info_write";
		}
		// 성공 로직
		log.info("성공 로직 실시 ");
		return "";
	}
}
