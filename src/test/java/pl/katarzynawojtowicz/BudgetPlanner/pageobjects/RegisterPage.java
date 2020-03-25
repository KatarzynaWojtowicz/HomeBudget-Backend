package pl.katarzynawojtowicz.BudgetPlanner.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	@FindBy(id = "name")
	private WebElement nameInput;
	
	@FindBy(id = "lastName")
	private WebElement lastNameInput;
	
	@FindBy(id = "login")
	private WebElement loginInput;
	
	@FindBy(id = "email")
	private WebElement emailInput;
	
	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(id = "password-confirm")
	private WebElement passwordConfirmInput;
	
	@FindBy(id = "register")
	private WebElement clickToRegisterbutton;
	
	@FindBy(id = "new-user-alert")
	WebElement newUserAllert;
	
	@FindBy(id = "required-fields-error-alert")
	private WebElement faildRegisterAlert;
	
	@FindBy(id= "new-user-alert")
	private WebElement newUserAlert;
	
	private WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	public void typeIntoNameInput(String name) {
		nameInput.sendKeys(name);
	}
	
	public void typeIntoLastNameInput(String lastName) {
		lastNameInput.sendKeys(lastName);
	}
	
	public void typeIntoLoginInput(String login) {
		loginInput.sendKeys(login);
	}
	
	public void typeIntoEmailInput(String email) {
		emailInput.sendKeys(email);
	}
	
	public void typeIntoPasswordInput(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void typeIntoPasswordConfirmInput(String passwordConfirm) {
		passwordConfirmInput.sendKeys(passwordConfirm);
	}
	
	public void clickToRegisterButton() {
		clickToRegisterbutton.click();
	}
	
	public boolean errorAlerIsDisplayed() {
		return faildRegisterAlert.isDisplayed();
	}
	
	public boolean newUserAlertIsDispayed() {
		return newUserAlert.isDisplayed();
	}
}
