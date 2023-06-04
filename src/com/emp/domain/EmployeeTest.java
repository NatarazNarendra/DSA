package com.emp.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeTest {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
        
		list.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		list.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		list.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		list.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		
		Map<String, Long> noOfMaleAndFemaleEmployees=
				list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));       
				System.out.println(noOfMaleAndFemaleEmployees);
				
          System.out.println(":Program2:!!!!rint the name of all departments in the organization?");
          Map<String, Long>count= list.stream().distinct()
        		  .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
          System.out.println(count);
			
				
	}

}
 