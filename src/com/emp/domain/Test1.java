package com.emp.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		
		List<String> list=Arrays.asList("Java","Springh","Spring", "Java");
	
		String s=list.stream().max(Comparator.comparing(String::length)).get();
		
		System.out.println(s);
		
		double d=list.stream().
				collect(Collectors.summarizingDouble(String::length)).getMax();

		System.out.println(d);
		
		long l=list.stream().count();
		System.out.println(l);
		
	     Map<String, Long>  count=list.stream().
		collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(count);
		
		 System.out.println("MAX---2nd height String");
		 
         Optional<String> secondstring=list.stream().sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst();
         System.out.println(secondstring);
         
         //Map<string ,Long> map=list.stream()
         
         
         Map<String, Long> counts = list.stream()
        		    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         System.out.println("Narendra"+counts);
         
         int occurrences = Collections.frequency(list, "Java");
         System.out.println(occurrences);
         
         String str="JavaIsProgramiing";
         Map<String,Long> occ=Arrays.stream(str.split(" ")).map(String::toLowerCase).
        		 collect(Collectors.groupingBy(e -> e,LinkedHashMap::new,Collectors.counting()));
         System.out.println("LastONE"+occ);
         
         
         
         String str22= "Communication";  
         Map<String, Long> result = Arrays.stream(str22.split("")).map(String::toLowerCase).
        		 collect(Collectors.groupingBy(s1 -> s, LinkedHashMap::new, Collectors.counting()));  
         System.out.println("RESULT"+result);  
         
	}

}
