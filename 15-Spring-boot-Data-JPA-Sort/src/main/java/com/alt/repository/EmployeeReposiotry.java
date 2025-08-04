package com.alt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.alt.entity.EmployeeEntityData;


@Repository
public interface EmployeeReposiotry extends JpaRepository<EmployeeEntityData, Integer> {
	
	@Query("SELECT e FROM EmployeeEntityData e")
	List<EmployeeEntityData>getAllEmployee();
	
	@Query("SELECT e FROM EmployeeEntityData e WHERE e.salary= :salary")
	EmployeeEntityData getEmployee(@Param("salary")int salary);
	
	@Query("SELECT e FROM EmployeeEntityData e WHERE e.dept= :dept AND e.salary= :salary")
	List<EmployeeEntityData> getEmployeeUsing(@Param("dept")String dept,@Param("salary")int salary);

}
