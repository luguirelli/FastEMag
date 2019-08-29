package br.com.fastEmag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fastEmag.exception.BRException;
import br.com.fastEmag.models.Employee;
import br.com.fastEmag.models.FuncionarioTO;
import br.com.fastEmag.models.Login;
import br.com.fastEmag.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/login2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee login2(@RequestBody Login login) {
		try {
			return employeeService.findEmployee(login.getEmail(), login.getSenha());
		} catch (Exception ex) {
			throw new BRException("Erro ao fazer login: " + ex.toString());
		}
	}

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public FuncionarioTO login(@RequestBody Login login) {
		try {
			return FuncionarioTO.converter(employeeService.login(login.getEmail(), login.getSenha()));
		} catch (Exception ex) {
			throw new BRException("Erro ao fazer login: " + ex.toString());
		}
	}

}
