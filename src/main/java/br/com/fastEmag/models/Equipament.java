package br.com.fastEmag.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_EQUIPAMENTO")
public class Equipament {

	@Column(name = "ID_EQUIPAMENTO")
	@Id
	@SequenceGenerator(name = "sq_equipamento", sequenceName = "sq_equipamento", allocationSize = 1)
	@GeneratedValue(generator = "sq_equipamento")
	private Long id;

	@Column(name = "DS_NOME")
	private String name;

	@Column(name = "DS_FABRICANTE")
	private String producer;

	@Column(name = "DS_MODELO")
	private String model;
	
	@Column(name = "DS_NUMERO_ANVISA")
	private String anvisaNumber;
	
	@Column(name = "DS_FUNCAO")
	private String function;

	@Column(name = "DS_NUMERO_SERIE")
	private String serialNumber;
	
	@Column(name = "DS_GRAU_IMPORTANCIA")
	private String importance;
	
	@Column(name = "DS_CRITICIDADE")
	private String criticality;
	
	@Column(name = "DT_PROXIMA_PREVENTIVA")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date nextPreventive;
	
	@ManyToOne(targetEntity = HospitalSector.class, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "ID_SETOR")
	@NotNull
	private HospitalSector hospitalSector;
	
	@ManyToOne(targetEntity = PatternEquipament.class, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "ID_EQ_PADRAO")
	@NotNull
	private PatternEquipament patternEquipament;

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

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAnvisaNumber() {
		return anvisaNumber;
	}

	public void setAnvisaNumber(String anvisaNumber) {
		this.anvisaNumber = anvisaNumber;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getCriticality() {
		return criticality;
	}

	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}

	public Date getNextPreventive() {
		return nextPreventive;
	}

	public void setNextPreventive(Date nextPreventive) {
		this.nextPreventive = nextPreventive;
	}

	public HospitalSector getHospitalSector() {
		return hospitalSector;
	}

	public void setHospitalSector(HospitalSector hospitalSector) {
		this.hospitalSector = hospitalSector;
	}

	public PatternEquipament getPatternEquipament() {
		return patternEquipament;
	}

	public void setPatternEquipament(PatternEquipament patternEquipament) {
		this.patternEquipament = patternEquipament;
	}
	
	
	
}
