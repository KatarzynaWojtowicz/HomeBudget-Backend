package pl.katarzynawojtowicz.BudgetPlanner.summary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.katarzynawojtowicz.BudgetPlanner.expense.ExpenseDao;
import pl.katarzynawojtowicz.BudgetPlanner.expense.ExpenseTo;
import pl.katarzynawojtowicz.BudgetPlanner.model.CustomUserDetails;
import pl.katarzynawojtowicz.BudgetPlanner.profit.ProfitDao;
import pl.katarzynawojtowicz.BudgetPlanner.profit.ProfitTo;

@RestController
@RequestMapping("/api/summary")
public class SummaryRestController {

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.yyyy");

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/monthly", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MonthSummaryTo>> getMonthlySummary() {

		CustomUserDetails userDetails = getUserDetails();
		List<ProfitTo> profits = ProfitDao.findByParameters(null, null, userDetails.getId());
		List<ExpenseTo> expenses = ExpenseDao.findByParameters(null, null, null, null,
				userDetails.getId());

		Set<String> months = new HashSet<>();
		for (ProfitTo profit : profits) {
			String dateString = simpleDateFormat.format(profit.getDataPrzychodu());
			months.add(dateString);
		}

		for (ExpenseTo expense : expenses) {
			String dateString = simpleDateFormat.format(expense.getDataWydatku());
			months.add(dateString);
		}

		List<MonthSummaryTo> result = new ArrayList<>();
		for (String monthName : months) {
			MonthSummaryTo monthSummary = new MonthSummaryTo();
			monthSummary.setMonthName(monthName);

			double profitSum = 0.0;
			for (ProfitTo profit : profits) {
				String profitMonth = simpleDateFormat.format(profit.getDataPrzychodu());
				if (profitMonth.equals(monthName)) {
					profitSum += profit.getKwota();
				}
			}
			monthSummary.setProfits(profitSum);

			double expenseSum = 0.0;
			for (ExpenseTo expense : expenses) {
				String expenseMonth = simpleDateFormat.format(expense.getDataWydatku());
				if (expenseMonth.equals(monthName)) {
					expenseSum += expense.getCena();
				}
			}

			monthSummary.setExpenses(expenseSum);
			result.add(monthSummary);
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	private CustomUserDetails getUserDetails() {
		return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
	}

}
