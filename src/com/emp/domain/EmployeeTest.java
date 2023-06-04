package com.emp.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
        
		list.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		list.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		list.add(new Employee(133, "Murali Gowda", 29, "Male", "Infrastructure", 2012, 18000.0));
		list.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		
		Map<String, Long> noOfMaleAndFemaleEmployees=
				list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));       
				System.out.println(noOfMaleAndFemaleEmployees);
				
          System.out.println(":Program2:!!!!rint the name of all departments in the organization?");
          Map<String, Long>count= list.stream().distinct()
        		  .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
          System.out.println(count);
          System.out.println(" What is the average salary of each department?");
          
      	Map<String, Double> avgsalary=
				list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));       
				System.out.println(avgsalary);
				
				
        System.out.println(":8*********88******_-------Program3:!!!!summarizingDouble");
		DoubleSummaryStatistics count1 =list.stream().
					collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(count1); 
		
		System.out.println("---------------8*888*88888888*8***88*****88**********Count the number of employees in each department?!!!!!!!");
		
		
		Map<String, Long> employeeCountByDepartment=
				list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(employeeCountByDepartment);
		
			System.out.println("Count2:::");
		Map<String, Long> empname2=
				list.stream().distinct().collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
		System.out.println(empname2);
		
		System.out.println("count3:::");
		Map<String, Long> empname3=
				list.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
		System.out.println(empname3);
		
		System.out.println("count4:::");
		Map<Integer, Long> count4=
				list.stream().collect(Collectors.groupingBy(Employee::getId, Collectors.counting()));
		System.out.println(count4);
	
		// display all Employees
	      System.out.println("Complete Employee list:");
	      list.stream().forEach(System.out::println);

         list.stream()
        .filter(e -> e.getYearOfJoining() > 2011)
        .filter(e -> e.getAge()>28)
        .map(Employee::getName)
        .forEach(System.out::println);
         System.out.println("2015");
         list.stream()
         .filter(e -> e.getYearOfJoining() > 2011)
         .map(Employee::getDepartment)
         .forEach(System.out::println);
          System.out.println("2015");
          
          
          System.out.println( "Count!!!!!Sales And Marketing");
          Map<String, Long> countMaleFemaleEmployeesInSalesMarketing=
        		  list.stream()
        		              .filter(e -> e.getDepartment()=="Sales And Marketing")
        		              .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        		   
        		  System.out.println(countMaleFemaleEmployeesInSalesMarketing);
         
          System.out.println("MAX");
          Employee salary=list.stream().max(Comparator.comparing(Employee::getSalary)).get();
          System.out.println(salary);
          System.out.println("Min");
          Employee salaryMin=list.stream().min(Comparator.comparing(Employee::getSalary)).get();
          System.out.println(salaryMin);
          
         // .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
          System.out.println("Min----.getDepartment()==\"Product Development");
          Employee salaryMins=list.stream() .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development").min(Comparator.comparing(Employee::getSalary)).get();
          System.out.println(salaryMins);
          
          System.out.println("MAX---findFirst");
          Optional<Employee> salarye=list.stream().sorted(Comparator.comparing(Employee::getSalary)).findFirst();
          System.out.println(salarye);
        		  
          
          System.out.println("MAX---findFirstgetYearOfJoining");
          Optional<Employee> salaryee=list.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
          System.out.println(salaryee);
          
          System.out.println("MAX---2nd height salary");
          Optional<Employee> salaryes=list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
          System.out.println(salaryes);
          
          
          System.out.println("employeeListByDepartment!!!!!!!!");
         List<Employee> employeeListByDepartment=
        		  list.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getDepartment))
         .collect(Collectors.toList());
         //((Stream<Employee>) employeeListByDepartment).peek(Employee::getAge). collect(Collectors.toList());
         System.out.println(employeeListByDepartment);
        
         
         
         System.out.println("employeeListByDepartment!!!!!!!!");
         Stream<Employee> employeeListByDepartmentw=
        		  list.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getDepartment));
        // .collect(Collectors.toMap(null, null));
         System.out.println(employeeListByDepartmentw);
         employeeListByDepartmentw.peek(Employee::getAge). collect(Collectors.toList());
        	
         
			/*
			 * Map<String, String> map=
			 * list.stream().sorted(Comparator.comparing(Employee::getName).
			 * thenComparing(Employee::getDepartment))
			 * .collect(Collectors.toMap(Employee::getName, Employee::getDepartment));
			 * System.out.println(map);
			 */
         
         
         System.out.println(" List down the names of all employees in each department?");
         Map<String, List<Employee>> map=
        		 list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        		          
         map.forEach((key, value) -> {
        	 System.out.println("Key !!!!!: " + key + " Value @@@@@: " + value);
        	 });
         
         DoubleSummaryStatistics employeeSalaryStatistics=
        		 list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));//
         System.out.println(employeeSalaryStatistics);
         System.out.println(employeeSalaryStatistics.getSum());
         
         System.out.println(":8*********88******_-------Program3:!!!!summarizingDouble");
 		DoubleSummaryStatistics count11 =list.stream().
 					collect(Collectors.summarizingDouble(Employee::getSalary));
 		System.out.println(count11); 
 		
 		
 		
 		Map<Boolean, List<Employee>> partitionEmployeesByAge=
 				list.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
 		partitionEmployeesByAge.forEach((key, value) -> {
       	 System.out.println("Key !!!!!: " + key + " Value @@@@@: " + value);
       	 });
	}

}
 