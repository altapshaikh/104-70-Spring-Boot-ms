package com.alt.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

	@GetMapping(value = "/hello")
	public Mono<List<Employee>>hello(){
		Employee emp=new Employee("raja", 9876543, "hyd");
		Employee emp1=new Employee("rani", 7876543, "hyd");
		List<Employee>list=new ArrayList<>();
		list.add(emp);
		list.add(emp1);
		return Mono.just(list);
	}
	@GetMapping(value = "/numbers")
	public Flux<Integer> numbers(){
		Flux.range(1, 10).delayElements(Duration.ofSeconds(1)).subscribe(data->{
			 System.out.println(data);
		 });
		 
		 return null;
	}
	
}
