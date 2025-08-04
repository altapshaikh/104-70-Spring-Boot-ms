package com.alt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.alt.entity.EmployeeEntityData;


@Repository
public interface EmployeeReposiotry extends JpaRepository<EmployeeEntityData, Integer> {
	
	@Query(value="SELECT * FROM EMPLOYEE",nativeQuery = true)
	List<EmployeeEntityData>getAllEmployee();
	
	@Query(value="SELECT e FROM EMPLOYEE e WHERE e.salary= :salary",nativeQuery = true)
	EmployeeEntityData getEmployee(@Param("salary")int salary);
	
	@Query(value="SELECT e FROM EMPLOYEE e WHERE e.dept= :dept AND e.salary= :salary",nativeQuery = true)
	List<EmployeeEntityData> getEmployeeUsing(@Param("dept")String dept,@Param("salary")int salary);

}
