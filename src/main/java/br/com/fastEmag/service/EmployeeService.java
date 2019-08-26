package br.com.fastEmag.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fastEmag.exception.BRException;
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

	public Employee login(String email, String senha) {

		Employee employee = employeeRepository.findByEmail(email);
		if (employee == null) {
			throw new BRException("Usuário não encontrado!");
		} else {
			String password = employee.getPassword();
			if (password.compareTo(senha) != 0) {
				throw new BRException("Senha inválida!");
			}

			return employee;
		}

	}

}
