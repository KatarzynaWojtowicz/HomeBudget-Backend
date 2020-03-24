package pl.katarzynawojtowicz.BudgetPlanner.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.HomePage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.LoginPage;

public class LoginTest extends AbstractBaseTest {

	@Test
	public void positiveLoginTest() {
		HomePage homePage = new HomePage(driver);
		homePage.pressLoginLink();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.typeIntoLoginField(CORRECT_LOGIN);
		loginPage.typeIntoPasswordField(CORRECT_PASSWORD);
		loginPage.pressLoginButton();

		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost:8080/expense/expense.html");
	}

	@Test
	public void negavitveLoginTest() {
		HomePage homePage = new HomePage(driver);
		homePage.pressLoginLink();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.typeIntoLoginField(CORRECT_LOGIN);
		loginPage.typeIntoPasswordField("wrong_password");
		loginPage.pressLoginButton();

		Assert.assertTrue(loginPage.errorMessageIsDisplayed());
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost:8080/signIn.html");
	}
}
