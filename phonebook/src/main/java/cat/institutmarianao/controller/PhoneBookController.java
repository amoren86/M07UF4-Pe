package cat.institutmarianao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhoneBookController {

	@GetMapping(value = "/")
	public String handleRequest() {
		return "phones";
	}

}
