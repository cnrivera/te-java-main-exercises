package com.techelevator.mailingList;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.mailingList.model.MailingListSignUp;

@Controller
public class MailingListController {

	@RequestMapping(path= {"/", "/home"}, method=RequestMethod.GET)
	public String showMailingListForm(ModelMap modelMap) {
		
		if (modelMap.containsAttribute("signUpData") == false) {
			MailingListSignUp empty = new MailingListSignUp();
			modelMap.put("signUpData", empty);
		}
		return "signUp";
	}

	@RequestMapping(path="/signUp", method=RequestMethod.POST)
	public String processMailingListForm(@Valid @ModelAttribute MailingListSignUp signUp,
										 BindingResult result,
										 RedirectAttributes ra) {
		
		if (result.hasErrors()) {
			
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			
			ra.addFlashAttribute("signUpData", signUp);
			ra.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "signUpData", result);
			return "redirect:/";
		} else {
			ra.addFlashAttribute("message", "You successfully signed up! Good job.");
			return "redirect:/thanks";
		}
	}

	@RequestMapping(path="/thanks", method=RequestMethod.GET)
	public String showThanksPage() {
		return "thanks";
	}
}
