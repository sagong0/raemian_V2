package raemian.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.client.domain.Reserve;
import raemian.common.dto.SearchDto;
import raemian.common.service.ReserveService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/reserve")
public class AdminReserveController {
	
	private final ReserveService reserveService;
	
	@GetMapping("/")
	public String reserveHome(@ModelAttribute SearchDto searchDto,Model model) {
		log.info("searchDto !!! = {}", searchDto);
		
		List<Reserve> reserves = reserveService.findReserves(searchDto);
		model.addAttribute("reserves", reserves);
		
		return "admin/view/reservation/reserve_main";
	}

	
	@PostMapping("/cancel")
	public String cancelReserve(@RequestParam int ridx, RedirectAttributes redirectAttributes) {
		int result = reserveService.cancel_reserve(ridx);
		if(result <= 0) {
			redirectAttributes.addFlashAttribute("msg", "취소에 실패하였습니다.");
		}
		// 성공로직
		redirectAttributes.addFlashAttribute("msg", "해당 예약을 취소하였습니다.");
		return "redirect:/reserve/";
	}
	
}
