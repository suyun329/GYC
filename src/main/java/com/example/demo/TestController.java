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

@Controller
public class TestController {
	/*@RequestMapping("/")
	public @ResponseBody NewsVO show() {
		NewsVO vo = new NewsVO();
		vo.setTitle("뉴욕증시 안도 랠리···S&P500 이틀째 최고치 마감");
		vo.setContent("나스닥 4주연속 상승세·S&P도 3주째 올라\r\n"
				+ "존슨앤드존슨 백신 폐기로 1%이상 떨어져\r\n"
				+ "맥도날드는 고객정보 유출에도 1%대 상승");
		vo.setCategory("STOCK");
		
		return vo;
	}





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
	*/
	
	
}
