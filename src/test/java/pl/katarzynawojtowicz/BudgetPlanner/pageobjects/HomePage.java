package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/a[1]")
	private WebElement registerButton;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/a[2]")
	private WebElement loginButton;

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
//		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("logo")));
		PageFactory.initElements(driver, this);
	}

	public void pressLoginLink() {
		loginButton.click();
	}

	public void pressRegisterLink() {
		registerButton.click();
	}

}
