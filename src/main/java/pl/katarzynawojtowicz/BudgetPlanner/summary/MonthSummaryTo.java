package pl.katarzynawojtowicz.BudgetPlanner.summary;

public class MonthSummaryTo {
	private String monthName;
	private double expenses;
	private double profits;

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}

	public double getProfits() {
		return profits;
	}

	public void setProfits(double profits) {
		this.profits = profits;
	}
}
