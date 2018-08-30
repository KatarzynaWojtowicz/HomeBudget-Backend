package pl.katarzynawojtowicz.BudgetPlanner.profit;

public class ProfitTo {
	private long idprofit;
	private String nazwa;
	private Float kwota;

	public long getIdprofit() {
		return idprofit;
	}

	public void setIdprofit(long idprofit) {
		this.idprofit = idprofit;
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

	public ProfitTo(long id, String nazwa, float kwota) {
		this.idprofit = id;
		this.nazwa = nazwa;
		this.kwota = kwota;
	}

	public ProfitTo() {
		super();
	}
}
