package com.emp.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) {
		String str= "Communication";  
		Map<Object, Long> result = Arrays.stream(str.split(""))
				.map(String::toLowerCase)
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting())); 
		
		System.out.println(result);  

	}

}
