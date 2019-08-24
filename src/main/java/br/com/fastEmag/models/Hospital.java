package br.com.fastEmag.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_HOSPITAL")
public class Hospital {

	@Column(name = "ID_HOSPITAL")
	@Id
	@SequenceGenerator(name = "sq_hospital", sequenceName = "sq_hospital", allocationSize = 1)
	@GeneratedValue(generator = "sq_hospital")
	private Long id;

	@Column(name = "DS_NOME")
	private String name;

	@Column(name = "DS_CIDADE")
	private String city;

	@Column(name = "DS_ESTADO")
	private String state;

	@Column(name = "DS_ENDERECO")
	private String address;

	@Column(name = "DS_TELEFONE")
	private String phone;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
