package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
@Controller
public class helloController {
	
	@RequestMapping("index")
	public String main(Model model) {
		model.addAttribute("data", "hello rozy~!");
		return "index";
	}
	
	@GetMapping("test.html")
    public String test(){
        //String value = "테스트 String";
        return "test.html";
    }
}
