package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.katarzynawojtowicz.BudgetPlanner.config.DriverUtils;

public class ProfitAddNewPage {
	
	@FindBy(id="nowy-przychod-nazwa-input")
	private WebElement nameField;
	
	@FindBy(id="nowy-przychod-kwota-input")
	private WebElement amountField;
	
	@FindBy(id="datepicker")
	private WebElement datePicker;
	
	@FindBy(id="add-button")
	private WebElement addButton;
	
	@FindBy(id="new-profit-alert")
	private WebElement alert;
	
//	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[4]/a")
//	private WebElement choosedDay;
	
	
	@FindBy(id="new-profit-error-alert")
	private WebElement error;
	
	
	private WebDriver driver;

	public ProfitAddNewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void putNameToField(String name) {
		DriverUtils.waitForAjaxToFinish(driver);
		nameField.click();
		nameField.click();
		nameField.sendKeys(Keys.CONTROL +"a");
		
		nameField.sendKeys(name);
	}
	
	public void putAmountToField(String amount) {
		amountField.click();
		amountField.click();
		
		amountField.sendKeys(amount);
	}
	
	public void putDateToField(String date) {
		datePicker.sendKeys("04.01.2020");
		amountField.click();
		nameField.click();
//		datePicker.sendKeys(Keys.TAB);
//		choosedDay.click();
		DriverUtils.waitForAjaxToFinish(driver);
	}
	
	public void clickOnAddButton() {
		driver.findElement(By.id("add-button")).click();
		DriverUtils.waitForAjaxToFinish(driver);
	}
	
	public boolean alertIsVisible() {
		return alert.isDisplayed();
	}
	
	public boolean errorIsVisible() {
		return error.isDisplayed();
	}
}
