package com.alt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import com.alt.entity.EmployeeEntity;

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
			list.add("yogesh");
			list.add("akshay");
			list.add("anand");
			int salary=9999;
			for(int i=0;i<4;i++) {
				
			
					EmployeeEntity studentEntity = new EmployeeEntity();
					//studentEntity.setId(0);
					studentEntity.setName(list.get(i));
					studentEntity.setAddress("hyd");
					studentEntity.setDept("account");
					studentEntity.setContactNo(9876543210l);
					studentEntity.setSalary(salary);
					repo.save(studentEntity);
					salary++;
				
			}
			
			//sorting default 
			List<EmployeeEntity> all = repo.findAll(Sort.by("salary"));
			all.forEach(data->{
				System.out.println(data);
			});
			//sorting  is salary DESC 
			List<EmployeeEntity> all1 = repo.findAll(Sort.by(Sort.Direction.DESC,"name"));
		
			all1.forEach(data->{
				
				System.out.println(data);
			});
		};
	}
}
