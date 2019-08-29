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
@Table(name = "TB_HISTORICO_DEFEITO")
public class HistoricoDefeito {

	@EmbeddedId
	private HistoricoDefeitoId historicoDefeitoId;

	public HistoricoDefeito(HistoricoDefeitoId historicoDefeitoId) {
		this.historicoDefeitoId = historicoDefeitoId;
	}

	public HistoricoDefeito() {
		super();
	}

	@ManyToOne(targetEntity = Hospital.class, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "ID_HOSPITAL")
	private Hospital hospital;

	public HistoricoDefeitoId getHistoricoDefeitoId() {
		return historicoDefeitoId;
	}

	public void setHistoricoDefeitoId(HistoricoDefeitoId historicoDefeitoId) {
		this.historicoDefeitoId = historicoDefeitoId;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}
