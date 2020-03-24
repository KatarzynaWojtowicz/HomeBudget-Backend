package pl.katarzynawojtowicz.BudgetPlanner.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

	public static void setInitialConfiguration() {
		DriverManager.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.getWebDriver().manage().window().maximize();
	}

	public static void navigateToPage(String pageUrl) {
		DriverManager.getWebDriver().navigate().to(pageUrl);
	}

	public static void waitForAjaxToFinish(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0").equals(true);
			}
		});
	}
}
