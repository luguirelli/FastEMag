package br.com.fastEmag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fastEmag.exception.BRException;
import br.com.fastEmag.models.Employee;
import br.com.fastEmag.models.Login;
import br.com.fastEmag.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee login(@RequestBody Login login) {
		try {
			return employeeService.findEmployee(login.getEmail(), login.getSenha());
		} catch (Exception ex) {
			throw new BRException("Erro ao fazer login: " + ex.toString());
		}
	}

}
