package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.katarzynawojtowicz.BudgetPlanner.config.DriverUtils;

public class LoginPage {

	@FindBy(id = "inputLogin")
	private WebElement loginField;

	@FindBy(id = "inputPassword")
	private WebElement passwordField;

	@FindBy(id = "signin")
	private WebElement loginButton;

	@FindBy(id = "login-error-alert")
	private WebElement errorMessage;

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void typeIntoLoginField(String login) {
		loginField.clear();
		loginField.sendKeys(login);
	}

	public void typeIntoPasswordField(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void pressLoginButton() {
		loginButton.click();
		DriverUtils.waitForAjaxToFinish(driver);
	}

	public void loginWithCredentials(String login, String password) {
		typeIntoLoginField(login);
		typeIntoPasswordField(password);
		pressLoginButton();
	}

	public boolean errorMessageIsDisplayed() {
		return errorMessage.isDisplayed();
	}

}
