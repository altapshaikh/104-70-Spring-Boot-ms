package com.alt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alt.entity.EmployeeEntity;
import com.alt.entity.EmployeeId;

public interface EmployeeRespository extends JpaRepository<EmployeeEntity, EmployeeId> {

}
