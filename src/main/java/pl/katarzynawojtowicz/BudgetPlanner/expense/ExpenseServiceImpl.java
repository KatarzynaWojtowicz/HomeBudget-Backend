package pl.katarzynawojtowicz.BudgetPlanner.expense;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.katarzynawojtowicz.BudgetPlanner.user.CustomUserDetails;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Override
	public List<ExpenseTo> getFindByStatus(Status status, String kategoria, String nazwa,
			String dataWydatku) throws ParseException {
		Date date = dataWydatku != null ? new SimpleDateFormat("dd.MM.yyyy").parse(dataWydatku) : null;
		CustomUserDetails userDetails = getUserDetails();
		List<ExpenseTo> searchByStatus = ExpenseDao.findByParameters(status, kategoria, nazwa, date,
				userDetails.getId());
		return searchByStatus;
	}

	@Override
	public void addNewExpense(ExpenseTo newExpense) {
		CustomUserDetails userDetails = getUserDetails();
		ExpenseDao.addNewExpense(newExpense, userDetails.getId());
	}

	@Override
	public void remove(long id) {
		CustomUserDetails userDetails = getUserDetails();
		ExpenseDao.removeExpense(id, userDetails.getId());
	}

	@Override
	public void edit(long id, ExpenseTo newExpense) {
		CustomUserDetails userDetails = getUserDetails();
		ExpenseDao.editExpense(newExpense, userDetails.getId());
	}

	@Override
	public ExpenseTo findById(long id) {
		CustomUserDetails userDetails = getUserDetails();
		ExpenseTo result = ExpenseDao.findById(id, userDetails.getId());

		return result;
	}

	private CustomUserDetails getUserDetails() {
		return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
	}
}
