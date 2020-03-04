package com.techelevator;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
class ColorController {

	
	@GetMapping("/colors")
	public String displayForm(ModelMap mm) {
		return "colors";
	}
	
	@PostMapping("/colors")
	public String setColor(@RequestParam String colorChoice, RedirectAttributes ra) {
		
		String cssName = colorChoice.toLowerCase().replace(" ", "");
		
		ra.addFlashAttribute("backgroundColor", cssName);
		
		return "redirect:/colors";
	}
}
