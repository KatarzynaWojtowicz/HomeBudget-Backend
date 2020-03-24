package pl.katarzynawojtowicz.BudgetPlanner.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.HomePage;

public class HomeTest extends AbstractBaseTest {

	@Test
	public void positiveClickOnRegisterButton() {
		HomePage homePage = new HomePage(driver);

		homePage.pressRegisterLink();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost:8080/register.html");
	}

	@Test
	public void positiveClickOnLogInButton() {
		HomePage homePage = new HomePage(driver);

		homePage.pressLoginLink();

		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost:8080/signIn.html");
	}

}
