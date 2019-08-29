package br.com.fastEmag.models;

import java.util.ArrayList;
import java.util.List;

public class HistDefTO {

	private String equipament;
	private String defect;
	private String sector;
	private String serialNumber;

	public HistDefTO(HistoricoDefeito historicoDefeito) {
		this.equipament = historicoDefeito.getHistoricoDefeitoId().getEquipament().getName();
		this.defect = historicoDefeito.getHistoricoDefeitoId().getDefect().getName();
		this.sector = historicoDefeito.getHistoricoDefeitoId().getEquipament().getHospitalSector().getName();
		this.serialNumber = historicoDefeito.getHistoricoDefeitoId().getEquipament().getSerialNumber();

	}

	public String getEquipament() {
		return equipament;
	}

	public void setEquipament(String equipament) {
		this.equipament = equipament;
	}

	public String getDefect() {
		return defect;
	}

	public void setDefect(String defect) {
		this.defect = defect;
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

	public static List<HistDefTO> listConverter(List<HistoricoDefeito> historicoDefeitoList) {
		ArrayList<HistDefTO> historicoDefeitoToList = new ArrayList<>();
		for (int i = 0; i < historicoDefeitoList.size(); i++) {
			historicoDefeitoToList.add(new HistDefTO(historicoDefeitoList.get(i)));
		}
		return historicoDefeitoToList;
	}

	public static HistDefTO converter(HistoricoDefeito historicoDefeito) {
		return new HistDefTO(historicoDefeito);
	}

}
