package com.alt;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
			
			int salary=9999;
			for(int i=0;i<100;i++) {
				
			
				EmployeeEntityData studentEntity = new EmployeeEntityData();
					//studentEntity.setId(0);
					studentEntity.setName("A_"+i);
					studentEntity.setAddress("hyd");
					studentEntity.setDept("account");
					studentEntity.setEmployeeContactNo(9876543210l);
					studentEntity.setSalary(salary);
					repo.save(studentEntity);
					salary++;
				
			}
			int size=10;
			int page=1;
			for(int i=0;i<10;i++) {
				System.out.println("===========page no:"+i+"===============");
				PageRequest of = PageRequest.of(i, size);
				Pageable pageable= of;
				Page<EmployeeEntityData> pageData = repo.findAll(pageable);
				
				System.out.println("Total Pages: "+pageData.getTotalPages());
				System.out.println("Total elements: "+pageData.getTotalElements());
				System.out.println("Slice size: "+pageData.getSize());
				
				List<EmployeeEntityData> content = pageData.getContent();
				content.forEach(data->{
					System.out.println(data);
				});
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
