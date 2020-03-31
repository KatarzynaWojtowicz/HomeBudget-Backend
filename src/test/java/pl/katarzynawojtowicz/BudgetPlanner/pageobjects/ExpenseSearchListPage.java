package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.katarzynawojtowicz.BudgetPlanner.config.DriverUtils;

public class ExpenseSearchListPage {

	@FindBy(xpath = "//*[@id=\"navbarNav\"]/ul[1]/li[2]/a")
	private WebElement addNewExpenseButton;

	@FindBy(xpath = "//*[@id=\"expenses-table\"]/tbody/tr[1]/td[1]")
	private WebElement firstCellInExpenseTable;

	@FindBy(id = "delete-button")
	private WebElement deleteButton;

	@FindBy(id = "edit_button")
	private WebElement editButton;

	private WebDriver driver;

	public ExpenseSearchListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToExpenseAddNewPage() {
		addNewExpenseButton.click();
	}

	public void markFirstExpense() {
		firstCellInExpenseTable.click();
	}

	public void goToEditExpense() {
		editButton.click();
	}

	public void deleteExpense() {
		deleteButton.click();
		DriverUtils.waitForAjaxToFinish(driver);
	}

	public String getFirstId() {
		return firstCellInExpenseTable.getText();
	}
}
