package com.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.Commander.LoginCommander;

@Controller
public class TestttController {

	//return login page
		@RequestMapping(value= {"/loginl"})
		public String loginPage(Model m) {
			m.addAttribute("loginCommand", new LoginCommander());
			return "login";
		}
	
}
