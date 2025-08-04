package com.alt;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


import com.alt.componet.TestCompoent;
import com.alt.entity.CourseEntity;
import com.alt.entity.StudentEntity;
import com.alt.repository.CourseRepository;
import com.alt.repository.StudentReposiotry;




@SpringBootApplication
public class Application {

	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
	
	    TestCompoent bean = run.getBean(TestCompoent.class);
	    bean.fetchAllStudent();
	}

	@Bean
	public CommandLineRunner loadDbRecords(StudentReposiotry srepo, 
			                                                                                                                CourseRepository crepo) {
		return args->{
			
			
			
			CourseEntity cEntity=new CourseEntity();
			cEntity.setTitle("SBMS");
		
			
			CourseEntity cEntity1=new CourseEntity();
			cEntity1.setTitle("AWS");
			
			crepo.saveAll(List.of(cEntity,cEntity1));
			
			StudentEntity sEntity=new StudentEntity();
			sEntity.setName("raja");
			
			sEntity.getCourse().add(cEntity);
			sEntity.getCourse().add(cEntity1);
			
			
			
			StudentEntity sEntity1=new StudentEntity();
			sEntity1.setName("rani");
			
			sEntity1.getCourse().add(cEntity);
			sEntity1.getCourse().add(cEntity1);
		
			
			srepo.saveAll(List.of(sEntity,sEntity1));
		
			srepo.findAll().forEach(data->{
				System.out.println(data.getCourse());
			});
		
			crepo.findAll().forEach(data->{
				System.out.println(data.getStudents());
			});
			
			
		};
	}
}
