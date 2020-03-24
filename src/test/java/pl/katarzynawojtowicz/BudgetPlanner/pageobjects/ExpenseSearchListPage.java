package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpenseSearchListPage {

	@FindBy(xpath = "//*[@id=\"navbarNav\"]/ul[1]/li[2]/a")
	private WebElement addNewExpenseButton;

	private WebDriver driver;

	public ExpenseSearchListPage(WebDriver driver) {
		this.driver = driver;
//		new WebDriverWait(driver, 30)
//				.until(ExpectedConditions.presenceOfElementLocated(By.id("search-button")));
		PageFactory.initElements(driver, this);
	}

	public void goToExpenseAddNewPage() {
		addNewExpenseButton.click();
	}
}
