package pl.katarzynawojtowicz.BudgetPlanner.expense;

public class ExpenseTo {
	private long id;
	private String nazwa;
	private String kategoria;
	private Float cena;
	private Status status;

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

	public ExpenseTo(long id, String nazwa, String kategoria, Float cena, Status status) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.kategoria = kategoria;
		this.cena = cena;
		this.status = status;
	}

	public ExpenseTo() {
		super();
	}

}
