package raemian.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientHomeController {
	@GetMapping("/")
	public String home() {
		return "client/view/index";
	}
	
}
