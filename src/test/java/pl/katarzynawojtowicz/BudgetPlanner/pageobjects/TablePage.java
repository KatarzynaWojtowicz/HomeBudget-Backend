package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TablePage {

	private WebElement tableWrapper;

	private WebDriver driver;

	public TablePage(WebDriver driver, String id) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		tableWrapper = driver.findElement(By.id(id));
	}

	public void clickOnRow(int rowIndex) {
		tableWrapper.findElement(By.xpath("//tbody/tr[" + (rowIndex + 1) + "]")).click();
	}

	public WebElement getCell(int rowIndex, int cellIndex) {
		return tableWrapper.findElement(By.xpath("//tbody/tr[" + (rowIndex + 1) + "]/td[" + (cellIndex + 1) + "]"));
	}

	public String getCellText(int rowIndex, int cellIndex) {
		return getCell(rowIndex, cellIndex).getText();
	}
}
