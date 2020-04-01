package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfitPage {

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div/div[2]")
	private WebElement ProfitId;
	
	@FindBy(id = "nowy-przychod-nazwa-input")
	private WebElement profitName;
	
	@FindBy(id = "nowy-przychod-kwota-input")
	private WebElement profitAmout;
	
	@FindBy(id ="datepicker")
	private WebElement profitDate;
	
	@FindBy(id = "save-button")
	private WebElement saveButton;
	
	
	
	private WebDriver driver;



	public EditProfitPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
