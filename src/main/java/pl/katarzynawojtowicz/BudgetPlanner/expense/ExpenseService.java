package pl.katarzynawojtowicz.BudgetPlanner.expense;

import java.text.ParseException;
import java.util.List;

public interface ExpenseService {

	public List<ExpenseTo> getFindByStatus(Status status, String kategoria, String nazwa,
			String dataWydatku) throws ParseException;

	public void addNewExpense(ExpenseTo newExpense);

	public void remove(long id);

	public void edit(long id, ExpenseTo newExpense);

	public ExpenseTo findById(long id);

}
