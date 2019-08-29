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
@Table(name = "TB_HISTORICO_Procedimento")
public class HistoricoProcedimento {

	@EmbeddedId
	private HistoricoProcedimentoId historicoProcedimentoId;

	public HistoricoProcedimento(HistoricoProcedimentoId historicoProcedimentoId) {
		this.historicoProcedimentoId = historicoProcedimentoId;
	}

	public HistoricoProcedimento() {

	}

	@Column(name = "DT_PROCEDIMENTO")
	private String dtProcedure;

	@ManyToOne(targetEntity = Hospital.class, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "ID_HOSPITAL")
	private Hospital hospital;

	public HistoricoProcedimentoId getHistoricoProcedimentoId() {
		return historicoProcedimentoId;
	}

	public void setHistoricoProcedimentoId(HistoricoProcedimentoId historicoProcedimentoId) {
		this.historicoProcedimentoId = historicoProcedimentoId;
	}

	public String getDtProcedure() {
		return dtProcedure;
	}

	public void setDtProcedure(String dtProcedure) {
		this.dtProcedure = dtProcedure;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}
