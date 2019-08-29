package br.com.fastEmag.models;

import java.util.Date;

public class EquipamentTO {

	private String name;
	private String importance;
	private String model;
	private String producer;
	private String anvisaNumber;
	private String serialNumber;
	private String function;
	private String criticality;
	private String nextPreventive;
	private String sector;
	private String patternEquipament;
	private Long hospitalId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getAnvisaNumber() {
		return anvisaNumber;
	}

	public void setAnvisaNumber(String anvisaNumber) {
		this.anvisaNumber = anvisaNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getCriticality() {
		return criticality;
	}

	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}

	public String getNextPreventive() {
		return nextPreventive;
	}

	public void setNextPreventive(String nextPreventive) {
		this.nextPreventive = nextPreventive;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getPatternEquipament() {
		return patternEquipament;
	}

	public void setPatternEquipament(String patternEquipament) {
		this.patternEquipament = patternEquipament;
	}

}
