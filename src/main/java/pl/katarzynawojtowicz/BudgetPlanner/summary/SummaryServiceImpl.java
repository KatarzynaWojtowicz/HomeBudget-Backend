package pl.katarzynawojtowicz.BudgetPlanner.summary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.katarzynawojtowicz.BudgetPlanner.expense.ExpenseDao;
import pl.katarzynawojtowicz.BudgetPlanner.expense.ExpenseTo;
import pl.katarzynawojtowicz.BudgetPlanner.profit.ProfitDao;
import pl.katarzynawojtowicz.BudgetPlanner.profit.ProfitTo;
import pl.katarzynawojtowicz.BudgetPlanner.user.CustomUserDetails;

@Service
public class SummaryServiceImpl implements SummaryService {

	@Override
	public List<MonthSummaryTo> getMonthlySummary() {

		CustomUserDetails userDetails = getUserDetails();
		List<ProfitTo> profits = ProfitDao.findByParameters(null, null, userDetails.getId());
		List<ExpenseTo> expenses = ExpenseDao.findByParameters(null, null, null, null,
				userDetails.getId());

		List<MonthSummaryTo> result = buildResultList(profits, expenses);

		return result;
	}

	private List<MonthSummaryTo> buildResultList(List<ProfitTo> profits, List<ExpenseTo> expenses) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.yyyy");
		Set<String> months = createMonthsSet(simpleDateFormat, profits, expenses);

		List<MonthSummaryTo> result = new ArrayList<>();
		for (String monthName : months) {
			MonthSummaryTo monthSummary = new MonthSummaryTo();
			monthSummary.setMonthName(monthName);
			monthSummary.setProfits(calculateProfitSum(profits, simpleDateFormat, monthName));
			monthSummary.setExpenses(calculateExpenseSum(expenses, simpleDateFormat, monthName));
			result.add(monthSummary);
		}
		return result;
	}

	private double calculateExpenseSum(List<ExpenseTo> expenses, SimpleDateFormat simpleDateFormat, String monthName) {
		double expenseSum = 0.0;
		for (ExpenseTo expense : expenses) {
			String expenseMonth = simpleDateFormat.format(expense.getDataWydatku());
			if (expenseMonth.equals(monthName)) {
				expenseSum += expense.getCena();
			}
		}
		return expenseSum;
	}

	private double calculateProfitSum(List<ProfitTo> profits, SimpleDateFormat simpleDateFormat, String monthName) {
		double profitSum = 0.0;
		for (ProfitTo profit : profits) {
			String profitMonth = simpleDateFormat.format(profit.getDataPrzychodu());
			if (profitMonth.equals(monthName)) {
				profitSum += profit.getKwota();
			}
		}
		return profitSum;
	}

	private Set<String> createMonthsSet(SimpleDateFormat simpleDateFormat, List<ProfitTo> profits,
			List<ExpenseTo> expenses) {
		Set<String> months = new HashSet<>();
		for (ProfitTo profit : profits) {
			String dateString = simpleDateFormat.format(profit.getDataPrzychodu());
			months.add(dateString);
		}

		for (ExpenseTo expense : expenses) {
			String dateString = simpleDateFormat.format(expense.getDataWydatku());
			months.add(dateString);
		}
		return months;
	}

	private CustomUserDetails getUserDetails() {
		return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
	}

}
