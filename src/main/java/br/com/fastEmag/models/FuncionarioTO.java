package br.com.fastEmag.models;

public class FuncionarioTO {
	
	private String name; 
	private String email; 
	private String occupation;
	private String cpf;
	private Long hospitalId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	public FuncionarioTO(Employee employee) {
		this.cpf = employee.getCpf();
		this.name = employee.getName();
		this.email = employee.getEmail();
		this.occupation = employee.getOccupation();
		this.hospitalId = employee.getHospital().getId();
	} 
	
	public static FuncionarioTO converter(Employee employee) {
		return new FuncionarioTO(employee);
	}
	
	
}
