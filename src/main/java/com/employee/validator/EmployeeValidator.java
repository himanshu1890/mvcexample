package com.employee.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.employee.model.EmployeeModel;

@Component
public class EmployeeValidator implements Validator{
	
	public boolean supports(Class clazz) {
		return EmployeeModel.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target,Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","error.firstName","First Name can't be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last Name can't be blank");
	}

}
