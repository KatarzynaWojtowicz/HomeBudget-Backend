package pl.katarzynawojtowicz.BudgetPlanner.expense;

public class ExpenseTo {
	private String nazwa;
	private String kategoria;
	private Float cena;
	private Status status;

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

	public ExpenseTo(String nazwa, String kategoria, Float cena, Status status) {
		super();
		this.nazwa = nazwa;
		this.kategoria = kategoria;
		this.cena = cena;
		this.status = status;
	}

	public ExpenseTo() {
		super();
	}

}
