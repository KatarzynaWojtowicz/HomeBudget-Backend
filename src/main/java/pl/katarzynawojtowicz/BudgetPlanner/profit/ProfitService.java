package pl.katarzynawojtowicz.BudgetPlanner.profit;

import java.text.ParseException;
import java.util.List;

public interface ProfitService {
	public void addNewProfit(ProfitTo newProfit);

	public List<ProfitTo> getFindByStatus(String nazwa, String dataPrzychodu) throws ParseException;

	public void remove(long id);

	public void edit(long id, ProfitTo newProfit);

	public ProfitTo findById(long id);

}
