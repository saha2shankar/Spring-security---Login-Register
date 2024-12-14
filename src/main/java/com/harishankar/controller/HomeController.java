package com.harishankar.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.harishankar.model.User;
import com.harishankar.repository.UserRepository;
import com.harishankar.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository repository;

	@ModelAttribute
	public void commonUser(Principal p, Model m) {

		if(p != null) {
			String email = p.getName();
			User user = repository.findByEmail(email);
			m.addAttribute("user", user);
		}
		
//		<th:block th:if="${user=NULL}">
//		
//		something for show
//		
//		</th:block>
		
	}
	
	@GetMapping("/")
	public String index() {
	return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/usersave")
	public String saveUser(@ModelAttribute User user, Model model){
		User saveuser = userService.saveUser(user);
				if(saveuser !=null) {
					model.addAttribute("message", "User added success !");
				}else {
					model.addAttribute("message", "user added Failed !");
				}
		return "register";
	}
	
	
	@GetMapping("/user/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/user/profile")
	public String Profile(Principal p, Model model) {
		String email = p.getName();
		User user = repository.findByEmail(email);
		model.addAttribute("user",user);
		
		return "profile";
	}

}
