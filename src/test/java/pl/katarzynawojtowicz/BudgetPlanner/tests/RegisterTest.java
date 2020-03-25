package pl.katarzynawojtowicz.BudgetPlanner.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pl.katarzynawojtowicz.BudgetPlanner.config.DriverUtils;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.HomePage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.RegisterPage;

public class RegisterTest extends AbstractBaseTest {

	@Test
	public void positiveRegisterTestWithoutLoginName() {
			HomePage homePage = new HomePage(driver);
			homePage.pressRegisterLink();
			
			RegisterPage registerPage = new RegisterPage(driver);
			registerPage.typeIntoNameInput("Majka");
			registerPage.typeIntoLastNameInput("Jeżowska");
			registerPage.typeIntoLoginInput("MajkaJ");
			registerPage.typeIntoEmailInput("majka@jezowska.pl");
			registerPage.typeIntoPasswordInput("hasloMajki");
			registerPage.typeIntoPasswordConfirmInput("hasloMajki");
			registerPage.clickToRegisterButton();
			DriverUtils.waitForAjaxToFinish(driver);
		
			Assert.assertTrue(registerPage.newUserAlertIsDispayed());
	}

	@Test
	public void negativeRegisterTestWithoutEmail() {
	
		HomePage homePage = new HomePage(driver);
		homePage.pressRegisterLink();

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.typeIntoNameInput("Maryla");
		registerPage.typeIntoLastNameInput("Rodowicz");
		registerPage.typeIntoLoginInput("Marylka");
		registerPage.typeIntoEmailInput("marylka@rodowicz.pl");
		registerPage.typeIntoPasswordInput("hasloMarylki");
		registerPage.typeIntoPasswordConfirmInput("");
		registerPage.clickToRegisterButton();
		DriverUtils.waitForAjaxToFinish(driver);

		Assert.assertTrue(registerPage.errorAlerIsDisplayed());
	}

}
