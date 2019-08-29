package br.com.fastEmag.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OSEquipamentTO {

	private String equipament;
	private String os;
	private String dateOS;
	private String employee;
	private String sector;
	private String serialNumber;

	public OSEquipamentTO(OSEquipament osEquipament) {
		this.equipament = osEquipament.getOsEquipamentId().getEquipament().getName();
		this.os = osEquipament.getOsEquipamentId().getOs().getName();
		this.employee = osEquipament.getEmployee().getName();
		this.dateOS = osEquipament.getDtOS();
		this.sector = osEquipament.getOsEquipamentId().getEquipament().getHospitalSector().getName();
		this.serialNumber = osEquipament.getOsEquipamentId().getEquipament().getSerialNumber();

	}

	public String getEquipament() {
		return equipament;
	}

	public void setEquipament(String equipament) {
		this.equipament = equipament;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getDateOS() {
		return dateOS;
	}

	public void setDateOS(String dateOS) {
		this.dateOS = dateOS;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public static List<OSEquipamentTO> listConverter(List<OSEquipament> osEquipamentList) {
		ArrayList<OSEquipamentTO> OSEquipamentToList = new ArrayList<>();
		for (int i = 0; i < osEquipamentList.size(); i++) {
			OSEquipamentToList.add(new OSEquipamentTO(osEquipamentList.get(i)));
		}
		return OSEquipamentToList;
	}

	public static OSEquipamentTO converter(OSEquipament osEquipament) {
		return new OSEquipamentTO(osEquipament);
	}

}
