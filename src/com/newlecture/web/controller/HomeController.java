package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*") //root에 있는 아이
public class HomeController {

	@RequestMapping("index")
	public String index(){
		
		return "home.index";
	}
	
	@RequestMapping("resource/old_customer/save")
	public void saveCodi() {
		
	}
}
