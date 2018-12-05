package pl.katarzynawojtowicz.BudgetPlanner.expense;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExpenseTo {
	private long id;
	private String nazwa;
	private String kategoria;
	private Float cena;
	private Status status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy", timezone = "Europe/Warsaw")
	private Date dataWydatku;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public Float getCena() {
		return cena;
	}

	public void setCena(Float kwota) {
		this.cena = kwota;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDataWydatku() {
		return dataWydatku;
	}

	public void setDataWydatku(Date dataWydatku) {
		this.dataWydatku = dataWydatku;
	}

	public ExpenseTo(long id, String nazwa, String kategoria, Float cena, Status status, Date dataWydatku) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.kategoria = kategoria;
		this.cena = cena;
		this.status = status;
		this.dataWydatku = dataWydatku;
	}

	public ExpenseTo() {
		super();
	}

}
