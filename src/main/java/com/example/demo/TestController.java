package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;


public class TestController {
	//@RequestMapping(value = "/home")
    //public String home(){
    //    return "index.html";
    //}
	
	
    //@ResponseBody
    //@RequestMapping("/valueTest")
    //public String valueTest(){
    //    String value = "테스트 String";
    //    return value;
    //}





//package test;
    //@GetMapping("test")
    //public String test(){
        //String value = "테스트 String";
    //    return "test";
    //}


    @GetMapping("/api")
    public String apiTest() throws IOException{
    	StringBuilder result = new StringBuilder();
		
    		String urlStr = "http://openapi.seoul.go.kr:8088/6564547a79737579313032585264796b/json/SeoulPublicLibraryInfo?" +
    				"serviceKey= S230308134434618219" +
    				"pageNo=0" +
    				"&numOfRows=20" +
    				"&type=json";
    		URL url = new URL(urlStr);
    		
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		conn.setRequestMethod("GET");
    		
    		BufferedReader rd;
    		
    		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		
    		String line;
    		
    		while ((line = rd.readLine()) != null) {
				result.append(line);
    		}
    		conn.disconnect();
    		
    	return result.toString();
    	
    }
	
}
