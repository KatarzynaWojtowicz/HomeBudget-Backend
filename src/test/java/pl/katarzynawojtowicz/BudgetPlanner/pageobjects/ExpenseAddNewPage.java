package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pl.katarzynawojtowicz.BudgetPlanner.config.DriverUtils;

public class ExpenseAddNewPage {

	@FindBy(id = "nowy-wydatek-nazwa-input")
	private WebElement expenseNameField;

	@FindBy(id = "nowy-wydatek-kategoria-input")
	private WebElement expenseCategoryField;

	@FindBy(id = "nowy-wydatek-cena-input")
	private WebElement expensePriceField;

	@FindBy(id = "status-select")
	private WebElement status;

	@FindBy(id = "datepicker")
	private WebElement expenseDate;

	@FindBy(id = "add-button")
	private WebElement addExpenseButton;

	@FindBy(id = "new-expense-error-alert")
	private WebElement errorAlert;

	@FindBy(id = "new-expense-alert")
	private WebElement okAllert;

	private WebDriver driver;

	public ExpenseAddNewPage(WebDriver driver) {
		this.driver = driver;
//		new WebDriverWait(driver, 30)
//				.until(ExpectedConditions.presenceOfElementLocated(By.id("nowy-wydatek-nazwa-input")));
		PageFactory.initElements(driver, this);
	}

	public void typeIntoexpenseNAmeField(String name) {
		expenseNameField.clear();
		expenseNameField.sendKeys(name);
	}

	public void typeIntoCategoryField(String category) {
		expenseCategoryField.clear();
		expenseCategoryField.sendKeys(category);
	}

	public void typeIntoPriceField(String d) {
		expensePriceField.clear();
		expensePriceField.sendKeys(d);
	}

	public void selectStatusOfExpense(String selectName) {
		Select statusSelect = new Select(status);
		statusSelect.selectByVisibleText(selectName);
	}

	public void pressAdd() {
		addExpenseButton.click();
		DriverUtils.waitForAjaxToFinish(driver);
	}

	public boolean errorMessageIsDisplayed() {
		return errorAlert.isDisplayed();
	}

	public boolean okAllertIsDisplayed() {
		return okAllert.isDisplayed();
	}
}
