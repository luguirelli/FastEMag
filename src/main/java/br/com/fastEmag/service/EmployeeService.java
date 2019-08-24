package br.com.fastEmag.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fastEmag.models.Employee;
import br.com.fastEmag.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee findEmployee(String email, String senha) {

		Employee employee = employeeRepository.find(email, senha);
		return employee;

	}

}
