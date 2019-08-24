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
@Table(name = "TB_DEFEITO_EQUIPAMENTO")

public class DefectEquipament {

	@EmbeddedId
	private DefectEquipamentId defectEquipamentId;

	public DefectEquipament() {

	}

	public DefectEquipament(DefectEquipamentId defectEquipamentId) {
		this.defectEquipamentId = defectEquipamentId;
	}

	@Column(name = "DT_DEFECT")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dtDefect;

	public DefectEquipamentId getDefectEquipamentId() {
		return defectEquipamentId;
	}

	public void setDefectEquipamentId(DefectEquipamentId defectEquipamentId) {
		this.defectEquipamentId = defectEquipamentId;
	}

	public Date getDtDefect() {
		return dtDefect;
	}

	public void setDtDefect(Date dtDefect) {
		this.dtDefect = dtDefect;
	}

}
