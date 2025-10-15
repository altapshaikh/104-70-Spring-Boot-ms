package com.alt;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindDuplicate {

	public static void main(String[] args) {
		  int arr[] = {1,2,3,4,5,4,5};
		     
		    List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());
		     
		  
		    Integer val = numbers.stream().sorted(Comparator.reverseOrder())
		                                           .distinct()
		                                           .skip(1)
		                                           .findFirst()
		                                           .get();
		    
		    System.out.println(val);

						   Set<Integer> value = numbers.stream().filter(data -> Collections.frequency(numbers, data) > 1 )
		   .collect(Collectors.toSet());
		   
		   System.out.println(value);
		   
		   
		             //   System.out.println("repeated number is: "+value);

	}

}
