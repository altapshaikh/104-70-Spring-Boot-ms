package com.alt.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alt.entity.EmployeeEntity;
import com.alt.entity.EmployeeId;
import com.alt.repository.EmployeeRespository;

@Component
public class empComponent {
    @Autowired
	private EmployeeRespository repo;
    
    
	public void create() {
	EmployeeId emp1=new EmployeeId(101l,4545l);
	EmployeeEntity entity=new EmployeeEntity(emp1,"raja","r&d");
	
	EmployeeId emp2=new EmployeeId(102l,4454l);
	EmployeeEntity entit2=new EmployeeEntity(emp2,"rani","qa");
	repo.save(entity);
	repo.save(entit2);
	}
}
