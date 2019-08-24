package br.com.fastEmag.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
/**
 * Classe da chave composta que compõe a tabela comanda_usuario
 *
 * @author Kyros
 *
 */
public class OSEquipamentId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(targetEntity = Equipament.class)
	@JoinColumn(name = "ID_EQUIPAMENTO")
	private Equipament equipament;

	@OneToOne(targetEntity = ServiceOrder.class)
	@JoinColumn(name = "ID_ORDEM_SERVICO")
	private ServiceOrder os;

	public OSEquipamentId() {

	}

	public OSEquipamentId(Equipament equipament, ServiceOrder os) {
		this.equipament = equipament;
		this.os = os;
	}

	public Equipament getEquipament() {
		return equipament;
	}

	public void setEquipament(Equipament equipament) {
		this.equipament = equipament;
	}

	public ServiceOrder getOs() {
		return os;
	}

	public void setOs(ServiceOrder os) {
		this.os = os;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipament == null) ? 0 : equipament.hashCode());
		result = prime * result + ((os == null) ? 0 : os.hashCode());
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
		OSEquipamentId other = (OSEquipamentId) obj;
		if (equipament == null) {
			if (other.equipament != null)
				return false;
		} else if (!equipament.equals(other.equipament))
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		return true;
	}

}
