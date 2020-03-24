package pl.katarzynawojtowicz.BudgetPlanner.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pl.katarzynawojtowicz.BudgetPlanner.config.DriverUtils;

public class RegisterTest {
	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void positiveRegisterTest() {
		driver.navigate().to("http://localhost:8080/");

		WebElement registerButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/a[1]"));
		registerButton.click();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://localhost:8080/register.html");

		WebElement nameInput = driver.findElement(By.id("name"));
		nameInput.sendKeys("Beata");

		WebElement lastNameInput = driver.findElement(By.id("lastName"));
		lastNameInput.sendKeys("Kozidrak");

		WebElement loginInput = driver.findElement(By.id("login"));
		loginInput.sendKeys("Beatka");

		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys("beatka@gmail.com");

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("hasloBeatki");

		WebElement passwordConfirmInput = driver.findElement(By.id("password-confirm"));
		passwordConfirmInput.sendKeys("hasloBeatki");

		WebElement button = driver.findElement(By.id("register"));
		button.click();
		DriverUtils.waitForAjaxToFinish(driver);

		WebElement newUserAllert = driver.findElement(By.id("new-user-alert"));
		Assert.assertTrue(newUserAllert.isDisplayed());

		Assert.assertEquals(URL, "http://localhost:8080/register.html");

	}

	@Test
	public void negativeRegisterTestWithoutLoginName() {
		driver.navigate().to("http://localhost:8080/");

		WebElement registerButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/a[1]"));
		registerButton.click();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://localhost:8080/register.html");

		WebElement nameInput = driver.findElement(By.id("name"));
		nameInput.sendKeys("Beata");

		WebElement lastNameInput = driver.findElement(By.id("lastName"));
		lastNameInput.sendKeys("Kozidrak");

		WebElement loginInput = driver.findElement(By.id("login"));
		loginInput.sendKeys("");

		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys("beatka@gmail.com");

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("hasloBeatki");

		WebElement passwordConfirmInput = driver.findElement(By.id("password-confirm"));
		passwordConfirmInput.sendKeys("hasloBeatki");

		WebElement button = driver.findElement(By.id("register"));
		button.click();

		WebElement faildReisterAlert = driver.findElement(By.id("required-fields-error-alert"));
		Assert.assertTrue(faildReisterAlert.isDisplayed());

		Assert.assertEquals(URL, "http://localhost:8080/register.html");
	}

	@Test
	public void negativeRegisterTestWithoutEmail() {
		driver.navigate().to("http://localhost:8080/");

		WebElement registerButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/a[1]"));
		registerButton.click();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://localhost:8080/register.html");

		WebElement nameInput = driver.findElement(By.id("name"));
		nameInput.sendKeys("Beata");

		WebElement lastNameInput = driver.findElement(By.id("lastName"));
		lastNameInput.sendKeys("Kozidrak");

		WebElement loginInput = driver.findElement(By.id("login"));
		loginInput.sendKeys("Beatka");

		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys("");

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("hasloBeatki");

		WebElement passwordConfirmInput = driver.findElement(By.id("password-confirm"));
		passwordConfirmInput.sendKeys("hasloBeatki");

		WebElement button = driver.findElement(By.id("register"));
		button.click();

		WebElement faildReisterAlert = driver.findElement(By.id("required-fields-error-alert"));
		Assert.assertTrue(faildReisterAlert.isDisplayed());
		Assert.assertEquals(URL, "http://localhost:8080/register.html");
	}

	@Ignore
	@Test
	public void negativeRegisterTestTooShortPassword() {
		driver.navigate().to("http://localhost:8080/");

		WebElement registerButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/a[1]"));
		registerButton.click();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://localhost:8080/register.html");

		WebElement nameInput = driver.findElement(By.id("name"));
		nameInput.sendKeys("Beata");

		WebElement lastNameInput = driver.findElement(By.id("lastName"));
		lastNameInput.sendKeys("Kozidrak");

		WebElement loginInput = driver.findElement(By.id("login"));
		loginInput.sendKeys("Beatka");

		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys("beatka@gmail.com");

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("haslo");

		WebElement passwordConfirmInput = driver.findElement(By.id("password-confirm"));
		passwordConfirmInput.sendKeys("haslo");

		WebElement button = driver.findElement(By.id("register"));
		button.click();

		WebElement faildReisterAlert = driver.findElement(By.id("required-fields-error-alert"));
		Assert.assertTrue(faildReisterAlert.isDisplayed());

		Assert.assertEquals(URL, "http://localhost:8080/register.html");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}

}
