package com.techelevator.mailingList;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.mailingList.model.MailingListSignUp;

@Controller
public class MailingListController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showMailingListForm() {
		
		return "signUp";
	}

	@RequestMapping(path="/signUp", method=RequestMethod.POST)
	public String processMailingListForm(@ModelAttribute MailingListSignUp signUp) {
		
		// This is where things happen for the signup
		// mailingListDao.save(signUp);

		return "redirect:/thanks";
	}

	@RequestMapping(path="/thanks", method=RequestMethod.GET)
	public String showThanksPage() {
		return "thanks";
	}
}
