package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.DAO.EmployeeDAOImpl;
import com.employee.model.EmployeeModel;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDAOImpl dao;
	
	public EmployeeModel getHello() {
		return dao.getModelHello();
		
	}

}
