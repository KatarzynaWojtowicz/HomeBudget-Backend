package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pl.katarzynawojtowicz.BudgetPlanner.config.DriverUtils;

public class ProfitSearchListPage {

	@FindBy(id = "delete-button")
	private WebElement deleteButton;

	@FindBy(id = "edit-button")
	private WebElement editButton;

	private TablePage profitList;

	private WebDriver driver;

	public ProfitSearchListPage(WebDriver driver) {
		super();
		this.driver = driver;

		profitList = new TablePage(driver, "expenses-table_wrapper");
	}

	public TablePage getProfitList() {
		return profitList;
	}
	
	public void deleteProfit() {
	//	deleteButton.click();
		driver.findElement(By.id( "delete-button")).click();
		DriverUtils.waitForAjaxToFinish(driver);
	}
}
