package br.com.fastEmag.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DEFEITO")
public class Defect {

	@Column(name = "ID_DEFEITO")
	@Id
	@SequenceGenerator(name = "sq_defeito", sequenceName = "sq_defeito", allocationSize = 1)
	@GeneratedValue(generator = "sq_defeito")
	private Long id;

	@Column(name = "DS_NOME")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
