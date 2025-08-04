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

import com.alt.entity.ProfileEntity;
import com.alt.entity.UserEntity;
import com.alt.repository.ProfileReposiotry;
import com.alt.repository.UsersRepository;


@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner loadDbRecords(UsersRepository urepo,ProfileReposiotry prepo) {
		return args->{
			
			ProfileEntity pentity=new ProfileEntity();
			UserEntity uentity=new UserEntity();
			
		//	pentity.setId(1l);
			pentity.setBio("full stack developer");
			pentity.setPhone("9876543210");
			
		//	uentity.setId(1l);
			uentity.setName("raja");
			uentity.setProfile(pentity);
			
			UserEntity save = urepo.save(uentity);
		
			 System.out.println(save);
		
			 urepo.deleteAll();
			
			 
		
			
		
		
		};
	}
}
