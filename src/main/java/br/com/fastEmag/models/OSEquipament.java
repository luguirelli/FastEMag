package br.com.fastEmag.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_OS_EQUIPAMENTO")

public class OSEquipament {

	@EmbeddedId
	private OSEquipamentId osEquipamentId;

	public OSEquipament() {

	}

	public OSEquipament(OSEquipamentId osEquipamentId) {
		this.osEquipamentId = osEquipamentId;
	}

	@ManyToOne(targetEntity = Employee.class, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "ID_FUNCIONARIO")
	private Employee employee;

	@ManyToOne(targetEntity = Hospital.class, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "ID_HOSPITAL")
	private Hospital hospital;

	@Column(name = "DT_OS")
	private String dtOS;

	public OSEquipamentId getOsEquipamentId() {
		return osEquipamentId;
	}

	public void setOsEquipamentId(OSEquipamentId osEquipamentId) {
		this.osEquipamentId = osEquipamentId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getDtOS() {
		return dtOS;
	}

	public void setDtOS(String dtOS) {
		this.dtOS = dtOS;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}
