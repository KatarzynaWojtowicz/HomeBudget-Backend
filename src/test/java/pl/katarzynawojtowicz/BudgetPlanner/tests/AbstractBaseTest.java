package pl.katarzynawojtowicz.BudgetPlanner.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pl.katarzynawojtowicz.BudgetPlanner.config.DriverManager;
import pl.katarzynawojtowicz.BudgetPlanner.config.DriverUtils;

public abstract class AbstractBaseTest {

	protected WebDriver driver;

	protected static final String CORRECT_PASSWORD = "hasloBenka";
	protected static final String CORRECT_LOGIN = "Benek";

	@BeforeMethod
	public void beforeTest() {
		this.driver = DriverManager.getWebDriver();
		DriverUtils.setInitialConfiguration();
		DriverUtils.navigateToPage("http://localhost:8080/");
	}

	@AfterMethod
	public void afterTest() {
		DriverManager.disposeDriver();
	}
}
