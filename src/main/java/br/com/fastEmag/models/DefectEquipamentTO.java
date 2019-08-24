package br.com.fastEmag.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DefectEquipamentTO {

	private String equipament;
	private String serialNumber;
	private String defect;
	private Date dateDefect;
	private String sector;

	public DefectEquipamentTO(DefectEquipament defectEquipament) {
		this.equipament = defectEquipament.getDefectEquipamentId().getEquipament().getName();
		this.defect = defectEquipament.getDefectEquipamentId().getDefect().getName();
		this.sector = defectEquipament.getDefectEquipamentId().getEquipament().getHospitalSector().getName();
		this.serialNumber = defectEquipament.getDefectEquipamentId().getEquipament().getSerialNumber();
		this.dateDefect = defectEquipament.getDtDefect();

	}

	public String getEquipament() {
		return equipament;
	}

	public void setEquipament(String equipament) {
		this.equipament = equipament;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDefect() {
		return defect;
	}

	public void setDefect(String defect) {
		this.defect = defect;
	}

	public Date getDateDefect() {
		return dateDefect;
	}

	public void setDateDefect(Date dateDefect) {
		this.dateDefect = dateDefect;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public static List<DefectEquipamentTO> listConverter(List<DefectEquipament> defectEquipamentList) {
		ArrayList<DefectEquipamentTO> defectEquipamentToList = new ArrayList<>();
		for (int i = 0; i < defectEquipamentList.size(); i++) {
			defectEquipamentToList.add(new DefectEquipamentTO(defectEquipamentList.get(i)));
		}
		return defectEquipamentToList;
	}

	public static DefectEquipamentTO converter(DefectEquipament defectEquipament) {
		return new DefectEquipamentTO(defectEquipament);
	}

}
