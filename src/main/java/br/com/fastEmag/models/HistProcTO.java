package br.com.fastEmag.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistProcTO {

	private String equipament;
	private String os;
	private String date;
	private String sector;
	private String serialNumber;

	public HistProcTO(HistoricoProcedimento historicoProcedimento) {
		this.equipament = historicoProcedimento.getHistoricoProcedimentoId().getEquipament().getName();
		this.os = historicoProcedimento.getHistoricoProcedimentoId().getOs().getName();
		this.date = historicoProcedimento.getDtProcedure();
		this.sector = historicoProcedimento.getHistoricoProcedimentoId().getEquipament().getHospitalSector().getName();
		this.serialNumber = historicoProcedimento.getHistoricoProcedimentoId().getEquipament().getSerialNumber();

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public static List<HistProcTO> listConverter(List<HistoricoProcedimento> historicoProcedimentoList) {
		ArrayList<HistProcTO> historicoProcedimentoToList = new ArrayList<>();
		for (int i = 0; i < historicoProcedimentoList.size(); i++) {
			historicoProcedimentoToList.add(new HistProcTO(historicoProcedimentoList.get(i)));
		}
		return historicoProcedimentoToList;
	}

	public static HistProcTO converter(HistoricoProcedimento historicoProcedimento) {
		return new HistProcTO(historicoProcedimento);
	}

}
