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
@Table(name = "TB_EQUIPAMENTO_PADRAO")
public class PatternEquipament {

	@Column(name = "ID_EQUIPAMENTO_PADRAO")
	@Id
	@SequenceGenerator(name = "sq_equipamento_padrao", sequenceName = "sq_equipamento_padrao", allocationSize = 1)
	@GeneratedValue(generator = "sq_equipamento_padrao")
	private Long id;

	@Column(name = "DS_NOME")
	private String name;

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

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}
