package com.myspent.myspent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myspent.myspent.model.Employee;
import com.myspent.myspent.model.User;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
  
}
