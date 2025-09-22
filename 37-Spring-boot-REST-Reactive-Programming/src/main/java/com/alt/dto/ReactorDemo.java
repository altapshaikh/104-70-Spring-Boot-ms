package com.alt.dto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorDemo {

	public static void main(String[] args) {
	  
		
		
		MsgDTO dto=new MsgDTO("welcome to reactive programming");
		
		Mono<String> mono = Mono.just("");
		
		mono.subscribe(System.out::println);
		
		       Flux<String> flux = Flux.just("A","B","C","D");
		       
		       flux.subscribe(data ->{
		    	   //service
		    	   System.out.println(data);
		       });
		       
	//trasformation on java streams but non-blobking      
		       
		       Flux<Integer> numbers = Flux.range(1, 10);
		       
		       numbers.map(n -> n*2).
		                        filter(n -> n >5)
		                        .subscribe(data ->{
		                        	System.out.println(data);
		                        });
		       
		       
		       
		       
		
  
	}

}
