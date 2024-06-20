package com.intellect.reportManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intellect.reportManagement.binding.UnlockForm;

@Controller
public class UserController {

	@GetMapping("/unlock")
	public String getUnlockPage(@RequestParam String email, Model model) {
		UnlockForm unlockForm = new UnlockForm();
		unlockForm.setUserEmail(email);
		model.addAttribute("unlock", unlockForm);
		return "unlock";
	}
	
	@PostMapping("/unlock")
	public String unlockUserAccount(@ModelAttribute UnlockForm unlock, Model model) {
		System.out.println(unlock);
		return "unlock";
	}

}
