package br.com.fastEmag.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_FUNCIONARIO")
public class Employee {

	@Column(name = "ID_FUNCIONARIO")
	@Id
	@SequenceGenerator(name = "sq_funcionario", sequenceName = "sq_funcionario", allocationSize = 1)
	@GeneratedValue(generator = "sq_funcionario")
	private Long id;

	@Column(name = "DS_NOME")
	private String name;

	@Column(name = "DS_PROFISSAO")
	private String occupation;

	@Column(name = "DS_CPF")
	private String cpf;

	@Column(name = "DS_EMAIL")
	private String email;

	@Column(name = "DS_SENHA")
	private String password;

	@ManyToOne(targetEntity = Hospital.class, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "ID_HOSPITAL")
	private Hospital hospital;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
