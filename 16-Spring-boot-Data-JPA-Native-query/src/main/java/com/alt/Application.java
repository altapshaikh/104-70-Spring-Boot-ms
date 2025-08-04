package com.alt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;


import com.alt.entity.EmployeeEntityData;
import com.alt.repository.EmployeeReposiotry;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner loadDbRecords(EmployeeReposiotry repo) {
		return args->{
			int j=0;
			List<String>list=new ArrayList<>();
			list.add("raja");
			list.add("rani");
			list.add("rani");
			list.add("akshay");
			list.add("anand");
			int salary=9999;
			for(int i=0;i<4;i++) {
				
			
				EmployeeEntityData studentEntity = new EmployeeEntityData();
					//studentEntity.setId(0);
					studentEntity.setName(list.get(i));
					studentEntity.setAddress("hyd");
					studentEntity.setDept("account");
					studentEntity.setEmployeeContactNo(9876543210l);
					studentEntity.setSalary(salary);
					repo.save(studentEntity);
					salary++;
				
			}
			
		//	  List<EmployeeEntityData> allEmployee = repo.getAllEmployee();
		//	  allEmployee.forEach(data->{ System.out.println(data); });
			 
		//	
			
		//	  EmployeeEntityData employee = repo.getEmployee(9999);
		//	  System.out.println(employee);
			 
		
	//	List<EmployeeEntityData> employeeUsing = repo.getEmployeeUsing("account", 10000);
	//	System.out.println(employeeUsing);
		
		};
	}
}
