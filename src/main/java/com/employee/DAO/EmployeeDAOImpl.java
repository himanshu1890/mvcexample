package com.employee.DAO;

import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeModel;
@Repository
public class EmployeeDAOImpl {
	
	
	EmployeeModel employeeModel = new EmployeeModel();
	public EmployeeModel getModelHello() {
		employeeModel.setHello("Hello World Model");
		
		return employeeModel;
		
	}

}
