package com.example.demo.application.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

	public Map<String,Integer> getGenderMap()
	{
		Map<String,Integer> genderMap = new LinkedHashMap<String, Integer>();
		genderMap.put("male",1);
		genderMap.put("female",2);
		return genderMap;
	}
	
}
