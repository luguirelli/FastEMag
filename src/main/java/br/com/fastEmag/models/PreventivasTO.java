package br.com.fastEmag.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PreventivasTO {

	private String equipament;
	private Date nextPreventive;
	private String sector;
	private String serialNumber;

	public PreventivasTO(Equipament equipament) {
		this.equipament = equipament.getName();
		this.sector = equipament.getHospitalSector().getName();
		this.nextPreventive = equipament.getNextPreventive();
		this.serialNumber = equipament.getSerialNumber();

	}

	public String getEquipament() {
		return equipament;
	}

	public void setEquipament(String equipament) {
		this.equipament = equipament;
	}

	public Date getNextPreventive() {
		return nextPreventive;
	}

	public void setNextPreventive(Date nextPreventive) {
		this.nextPreventive = nextPreventive;
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

	public static List<PreventivasTO> listConverter(List<Equipament> equipamentList) {
		ArrayList<PreventivasTO> preventivaToList = new ArrayList<>();
		for (int i = 0; i < equipamentList.size(); i++) {
			preventivaToList.add(new PreventivasTO(equipamentList.get(i)));
		}
		return preventivaToList;
	}

	public static PreventivasTO converter(Equipament equipament) {
		return new PreventivasTO(equipament);
	}

}
