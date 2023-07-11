package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping(value = "/home")
    public String home(){
        return "index.html";
    }
	
	@RequestMapping(value = "/home")
    public String test(){
        return "test.jsp";
    }
	
    @ResponseBody
    @RequestMapping("/valueTest")
    public String valueTest(){
        String value = "테스트 String";
        return value;
    }
}

