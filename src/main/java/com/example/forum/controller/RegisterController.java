package com.example.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.forum.model.User;
import com.example.forum.repository.UserRepository;
import com.example.forum.service.ClientService;

@Controller
public class RegisterController {
	
	@Autowired
	ClientService clientService;

	@RequestMapping(value="registration", method=RequestMethod.GET)
	public String registaration(Model model){
		model.addAttribute("newUser", new User());
		return "registration";
	}
	
	@RequestMapping(value="registration", method=RequestMethod.POST)
	public String registarationPOST(Model model, User newUser){
		if(clientService.registerNewUser(newUser)){
			return "redirect:/login";
		}
		else{
			return "redirect:/registration";
		}
	}
}