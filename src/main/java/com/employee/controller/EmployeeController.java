package com.employee.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.employee.model.EmployeeModel;
import com.employee.service.EmployeeService;
import com.employee.validator.EmployeeValidator;

@Controller
@RequestMapping("/employee")
@SessionAttributes("employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	private Validator validator;

	// constructor of controller class to initliaize validator object
	public EmployeeController() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	/*
	 * code for validator class
	 * 
	 * @Autowired EmployeeValidator validator;
	 */

	/*
	 * //@RequestMapping("/hello") public String getHelloWorld(Model model) {
	 * System.out.println("In method");
	 * model.addAttribute("hello",employee.getHello()); return "helloWorld"; }
	 */

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		EmployeeModel employeeMo = new EmployeeModel();
		model.addAttribute("employee", employeeMo);
		return "addEmployee";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("employee") EmployeeModel employeeMO, BindingResult result,
			SessionStatus session) {

		// check constraint violation
		Set<ConstraintViolation<EmployeeModel>> violations = validator.validate(employeeMO);

		// print field error violation for each constraint violation
		for (ConstraintViolation<EmployeeModel> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			result.addError(new FieldError("employee", propertyPath, "Invalid" + propertyPath + "(" + message + ")"));
		}

		/*
		 * This code will be replaced by validator() and below 2-3 lines of code will be
		 * added boolean error=false;
		 * 
		 * if(employeeMO.getFirstName().isEmpty()) { result.rejectValue("firstName",
		 * "error.firstName"); error=true; }
		 * 
		 * if(employeeMO.getLastName().isEmpty()) { result.rejectValue("lastName",
		 * "error.lastName"); error=true; } if(error) { return "addEmployee"; }
		 */

		/*
		 * Custom Validator code
		 * 
		 * validator.validate(employeeMO, result);
		 */

		if (result.hasErrors()) {
			return "addEmployee";
		}

		// Add record in DB
		// employeeService.createNewRecord(employeeMo);

		session.setComplete();
		return "redirect:/employee/sucess";
	}

	@RequestMapping(value = "/sucess", method = RequestMethod.GET)
	public String success(Model model) {
		return "addSuccess";
	}

}
