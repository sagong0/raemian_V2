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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String info_home(@RequestParam(required = false) String searchWord,Model model) {
		List<ConfigInfo> configs = null;
		
		if(searchWord == null || searchWord.trim().isEmpty()) {
			configs= configInfoService.findAll();
		} else{
			configs = configInfoService.findBySearch(searchWord);
		}
		
		log.info("configs = {}", configs);
		model.addAttribute("configs", configs);
		return "admin/view/config/info_main";
	}
	
	@GetMapping("/write")
	public String newInfoFormCreate() {
		return "admin/view/config/info_write";
	}
	
	@PostMapping("/write")
	public String newInfoForm(@Valid @ModelAttribute ConfigInfoForm infoForm, BindingResult bindingResult,Model model) {
		
		if(!infoForm.getAuse().equals("O") && !infoForm.getAuse().equals("X")) {
			bindingResult.rejectValue(infoForm.getAuse(), "abc", "사용여부를 확인 해주세요.");
		}
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult);
			return "admin/view/config/info_write";
		}
		// 성공 로직
		int sign = configInfoService.insert_config(infoForm);
		if(sign <= 0) {
			return "admin/view/config/info_write";
		}
		return "redirect:/config/";
	}
	
	@PostMapping("/delete")
	public String delete_config(@RequestParam int aidx, RedirectAttributes redirectAttributes) {
		log.info("aidx = {}", aidx);
		int result = configInfoService.delete_config(aidx);
		if(result <= 0) {
			redirectAttributes.addFlashAttribute("msg", "삭제에 실패하였습니다.");
			return "admin/view/config/info_main";
		}
		redirectAttributes.addFlashAttribute("msg", "성공적으로 삭제 되었습니다.");
		return "redirect:/config/";
	}
}



