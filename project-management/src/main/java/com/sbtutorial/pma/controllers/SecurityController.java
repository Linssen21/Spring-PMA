 package com.sbtutorial.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sbtutorial.pma.dao.AccountRepository;
import com.sbtutorial.pma.dao.UserAccountRepository;
import com.sbtutorial.pma.entities.UserAccount;

@Controller
public class SecurityController {
	
	@Autowired
	UserAccountRepository accountRepository;
	
	/**
	 * Get the Hash method 
	 */
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@GetMapping("/register")
	public String register(Model model) {
		UserAccount userAccount = new UserAccount();
		model.addAttribute(userAccount);
		
		return "security/register";
		
	}
	
	@PostMapping("/register/save")
	public String saveUser(Model model, UserAccount user) {
		user.setPassword(bCryptEncoder.encode(user.getPassword()));
		accountRepository.save(user);
		return "redirect:/";
	}

}
