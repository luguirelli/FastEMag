package br.com.fastEmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fastEmag.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "select * from TB_FUNCIONARIO f where f.DS_EMAIL=:email AND f.DS_SENHA=:senha", nativeQuery = true)
	Employee find(@Param(value = "email") String email, @Param(value = "senha") String senha);
	
	@Query(value = "select * from TB_FUNCIONARIO f where f.DS_EMAIL=:email", nativeQuery = true)
	Employee findByEmail(@Param(value = "email") String email);

}
