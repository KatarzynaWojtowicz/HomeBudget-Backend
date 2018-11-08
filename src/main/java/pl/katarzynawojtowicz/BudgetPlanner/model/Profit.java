package pl.katarzynawojtowicz.BudgetPlanner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profit")
public class Profit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "nazwa")
	private String nazwa;

	@Column(name = "kwota")
	private Float kwota;

	public Profit() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Float getKwota() {
		return kwota;
	}

	public void setKwota(Float kwota) {
		this.kwota = kwota;
	}
}
