package com.example.spring02.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	private static Logger logger = 
			LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("message", "홈페이지에 오신걸 환영합니다");
		return "home";
	}
}
