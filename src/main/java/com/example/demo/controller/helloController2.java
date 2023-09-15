package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.NewsVO;

import org.springframework.ui.Model;
@RestController
public class helloController2 {
	
	StringBuilder result = new StringBuilder();
	
	//빈 생성자
	public  helloController2() {
		
	}
	
	@GetMapping("/demo/hello")
	public JSONObject Hellotest()throws IOException, ParseException{
		String attributeValue;
		String a = "null";
		
		
		String urlStr = "http://openapi.seoul.go.kr:8088/6564547a79737579313032585264796b/" +
    				"json/tvYeyakCOllect/" + //tvYeyakCOllect <- ListPublicReservationDetail
    				"0/" +
    				"20/"; //+
    				//num; //serviceID
		URL url = new URL(urlStr);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		BufferedReader rd;
		
		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String line;
		
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
//		a=result.toString();
//		
		JSONParser jsonParser = new JSONParser();
//
//		//JSON데이터를 넣어 JSON Object 로 만들어 준다.
		JSONObject jsonObject = (JSONObject)jsonParser.parse(result.toString());
		JSONObject _tvYeyakCOllect = (JSONObject)jsonObject.get("tvYeyakCOllect");
		//a = _tvYeyakCOllect.toJSONString();

        return _tvYeyakCOllect;
    }
	
}
