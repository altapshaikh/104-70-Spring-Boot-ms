package com.alt;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alt.entity.StudentEntity;
import com.alt.repository.StudentReposiotry;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner loadDbRecords(StudentReposiotry repo) {
		return args->{
			int j=0;
			for(int i=0;i<55;i++) {
				
				if(j==0) {
					StudentEntity studentEntity = new StudentEntity();
					//studentEntity.setId(0);
					studentEntity.setName("raja_"+i);
					studentEntity.setAddress("hyd");
					studentEntity.setStream("IT");
					studentEntity.setContactNo(9876543210l);
					repo.save(studentEntity);
					j=1;
				}else {
					StudentEntity studentEntity = new StudentEntity();
					//studentEntity.setId(0);
					studentEntity.setName("raja_"+i);
					studentEntity.setAddress("mumbai");
					studentEntity.setStream("Mechanical");
					studentEntity.setContactNo(8876543210l);
					repo.save(studentEntity);
					j=0;
				}
				
			}
			//fetch all the student
			/*
			 * List<StudentEntity> allStudent = repo.findAll(); allStudent.forEach(data ->{
			 * System.out.println(data); });
			 */
			//fetch a specific student with ID
			
			Optional<StudentEntity> student = repo.findById(5);
			StudentEntity studentEntity = student.get();
			System.out.println(studentEntity);
			
			//delete a specific record by id
		//	   repo.deleteById(5);
			   
			   //fetch the record with the student name
			   //findByXXX
			//   StudentEntity byName = repo.findByName("raja_2");
			   
		//		System.out.println(byName);
				
		//		StudentEntity byNameAndContactNo = repo.findByNameAndContactNo("raja_3",9876543210l);
		//		System.out.println(byNameAndContactNo);
				
		//		StudentEntity byNameAndStream = repo.findByNameAndStream("raja_2", "IT");
		//		System.out.println(byNameAndStream);
				
				//create custom method to below operations
				
				//greater than
				//less than
				//deleteByname
			   //deleteBystream
				
				
				//update the record
				
			///	2	8876543210	mumbai	raja_1	Mechanical
				StudentEntity studentEntity1 = new StudentEntity();
			    studentEntity1.setId(0);
				studentEntity1.setName("rani");
				studentEntity1.setAddress("mumbai");
				studentEntity1.setStream("IT");
				studentEntity1.setContactNo(88888888l);
				repo.save(studentEntity1);
				
				
				
		};
	}
}
