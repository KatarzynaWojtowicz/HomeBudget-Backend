package pl.katarzynawojtowicz.BudgetPlanner.profit;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProfitTo {
	private long idprofit;
	private String nazwa;
	private Float kwota;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
	private Date dataPrzychodu;

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

	public Date getDataPrzychodu() {
		return dataPrzychodu;
	}

	public void setDataPrzychodu(Date dataPrzychodu) {
		this.dataPrzychodu = dataPrzychodu;
	}

	public ProfitTo(long id, String nazwa, float kwota, Date dataPrzychodu) {
		this.idprofit = id;
		this.nazwa = nazwa;
		this.kwota = kwota;
		this.setDataPrzychodu(dataPrzychodu);
	}

	public ProfitTo() {
		super();
	}

}
