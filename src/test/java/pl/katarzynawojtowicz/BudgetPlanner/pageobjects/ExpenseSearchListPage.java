package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.katarzynawojtowicz.BudgetPlanner.config.DriverUtils;

public class ExpenseSearchListPage {

	@FindBy(xpath = "//*[@id=\"navbarNav\"]/ul[1]/li[2]/a")
	private WebElement addNewExpenseButton;
	
	@FindBy(xpath="//*[@id=\"navbarNav\"]/ul[1]/li[3]/a")
	private WebElement profits;

	@FindBy(id = "delete-button")
	private WebElement deleteButton;

	@FindBy(id = "edit-button")
	private WebElement editButton;
	
	@FindBy(xpath="//*[@id=\"navbarNav\"]/ul[1]/li[4]/a")
	private WebElement addNewProfit;

	private TablePage expenseList;

	private WebDriver driver;

	public ExpenseSearchListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		expenseList = new TablePage(driver, "expenses-table_wrapper");
	}

	public void goToExpenseAddNewPage() {
		addNewExpenseButton.click();
	}

	public void goToEditExpense() {
		editButton.click();
	}

	public void deleteExpense() {
		deleteButton.click();
		DriverUtils.waitForAjaxToFinish(driver);
	}

	public TablePage getExpenseList() {
		return expenseList;
	}
	
	public void goToProfitAddNewPage() {
		addNewProfit.click();
	}
	
	public void goToProfitSearchListPage() {
		profits.click();
	}

}
