package pl.katarzynawojtowicz.BudgetPlanner.profit;

public class ProfitTo {
	private String nazwa;
	private Float kwota;

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

	public ProfitTo(String nazwa, float kwota) {
		this.nazwa = nazwa;
		this.kwota = kwota;
	}

	public ProfitTo() {
		super();
	}
}
