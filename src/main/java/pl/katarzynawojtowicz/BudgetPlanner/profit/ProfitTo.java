package pl.katarzynawojtowicz.BudgetPlanner.profit;

public class ProfitTo {
	private String nazwa;
	private String kwota;

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public ProfitTo(String nazwa, String kwota) {
		this.nazwa = nazwa;
		this.kwota = kwota;
	}

	public ProfitTo() {
		super();
	}
}
