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

	@Column(name = "DT_OS")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dtOS;

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

	public Date getDtOS() {
		return dtOS;
	}

	public void setDtOS(Date dtOS) {
		this.dtOS = dtOS;
	}

}
