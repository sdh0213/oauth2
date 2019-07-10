package com.ktds.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;

@RestController
public class TestController {

	@RequestMapping("/rest/hello1")
	public String test() {
		return "Hello benz new versoin!!";
	}
	
	@RequestMapping("/test1") 	
	@ResponseBody
	public Map<String, String> jsonReturnSample(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "benz");
        map.put("since", "1886");
        map.put("kind", "car");
        return map;
    }
}