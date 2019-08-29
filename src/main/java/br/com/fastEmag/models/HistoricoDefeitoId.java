package br.com.fastEmag.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class HistoricoDefeitoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne(targetEntity = Equipament.class)
	@JoinColumn(name = "ID_EQUIPAMENTO")
	private Equipament equipament;

	@OneToOne(targetEntity = Defect.class)
	@JoinColumn(name = "ID_DEFEITO")
	private Defect defect;

	public Equipament getEquipament() {
		return equipament;
	}

	public void setEquipament(Equipament equipament) {
		this.equipament = equipament;
	}

	public Defect getDefect() {
		return defect;
	}

	public void setDefect(Defect defect) {
		this.defect = defect;
	}

	public HistoricoDefeitoId() {

	}

	public HistoricoDefeitoId(Equipament equipament, Defect defect) {
		super();
		this.equipament = equipament;
		this.defect = defect;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((defect == null) ? 0 : defect.hashCode());
		result = prime * result + ((equipament == null) ? 0 : equipament.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoDefeitoId other = (HistoricoDefeitoId) obj;
		if (defect == null) {
			if (other.defect != null)
				return false;
		} else if (!defect.equals(other.defect))
			return false;
		if (equipament == null) {
			if (other.equipament != null)
				return false;
		} else if (!equipament.equals(other.equipament))
			return false;
		return true;
	}

}
