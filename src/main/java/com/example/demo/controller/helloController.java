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
@Controller
public class helloController {
	
	private String attributeName;
	StringBuilder result = new StringBuilder();

	
	@RequestMapping("/gonggong")
	public String home(String num) {
		//model.addAttribute("val", val);
		return "gonggong";
	}
	
	@GetMapping("home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/gonggong")
	public String gonggong(@RequestParam(value="num") String num, Model model)throws IOException, ParseException{
		String attributeValue;
		String num1 = num;
		String a = "null";
		//StringBuilder result = new StringBuilder();
		
		
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
		//a=result.toString();
		
		//model.addAttribute(attributeName = "num1", attributeValue= a);  
		
		//json 가져오기
		JSONParser jsonParser = new JSONParser();

		//JSON데이터를 넣어 JSON Object 로 만들어 준다.
		JSONObject jsonObject = (JSONObject)jsonParser.parse(result.toString());
		JSONObject _tvYeyakCOllect = (JSONObject)jsonObject.get("tvYeyakCOllect");
		JSONArray _row = (JSONArray)_tvYeyakCOllect.get("row");
			
		//배열 추출
    	JSONObject row_nm = (JSONObject)_row.get(0);
    	
		//model.addAttribute(attributeName = "num1", attributeValue= row_nm.get("PLACENM").toString()); 
    	model.addAttribute("msg", "success");
		model.addAttribute(attributeName = "num1", attributeValue= row_nm.get("SVCID").toString());
		model.addAttribute(attributeName = "plac", attributeValue= row_nm.get("PLACENM").toString());
		model.addAttribute(attributeName = "d_1", attributeValue= row_nm.get("RCPTBGNDT").toString());
		model.addAttribute(attributeName = "d_2", attributeValue= row_nm.get("RCPTENDDT").toString()); 
		
		
	
    	
//		//JSONObject isonObject = new JSONObject(result.toString());
//		
//		//conn.disconnect();
//		model.addAttribute(attributeName = "num1", attributeValue= num1);
//		model.addAttribute(attributeName = "plac", attributeValue= row_nm.get("PLACENM").toString());
//		model.addAttribute(attributeName = "d_1", attributeValue= row_nm.get("RCEPTBEGDT").toString());
//		model.addAttribute(attributeName = "d_2", attributeValue= row_nm.get("RCEPTENDDT").toString());
//
		//model.addAttribute(attributeName = "insttNm", attributeValue= a.toString());  
		
		
		
        return "gonggong";
    } //서비스 ID입력하면 해당 정보 나옴
	
	
	//@GetMapping("/gonggong")
	public void gonggong2() throws ParseException {
		
		 
	}

	/*@GetMapping("/api")
    public String apiTest() throws IOException{
    	StringBuilder result = new StringBuilder();
		
    		String urlStr = "http://openapi.seoul.go.kr:8088/6564547a79737579313032585264796b/" +
    				"json/ListPublicReservationDetail/" +
    				"0/" +
    				"20/" +
    				"S230307162913978115/";
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
    }*/
	 
	/*
	@RequestMapping("/home")
	public @ResponseBody NewsVO show() {
		NewsVO vo = new NewsVO();
		vo.setTitle("뉴욕증시 안도 랠리···S&P500 이틀째 최고치 마감");
		vo.setContent("나스닥 4주연속 상승세·S&P도 3주째 올라\r\n"
				+ "존슨앤드존슨 백신 폐기로 1%이상 떨어져\r\n"
				+ "맥도날드는 고객정보 유출에도 1%대 상승");
		vo.setCategory("STOCK");
		
		return vo;
	}
	*/
}
