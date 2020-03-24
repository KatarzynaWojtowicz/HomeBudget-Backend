package pl.katarzynawojtowicz.BudgetPlanner.tests;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;

import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.ExpenseAddNewPage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.ExpenseSearchListPage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.HomePage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.LoginPage;

public class ExpenseTests extends AbstractBaseTest {

	@Test
	public void positiveAddNewExpense() {
		HomePage homePage = new HomePage(driver);
		homePage.pressLoginLink();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithCredentials(CORRECT_LOGIN, CORRECT_PASSWORD);

		ExpenseSearchListPage expenseSearchPage = new ExpenseSearchListPage(driver);
		expenseSearchPage.goToExpenseAddNewPage();

		ExpenseAddNewPage expenseAddNewPage = new ExpenseAddNewPage(driver);

		driver.findElement(By.id("nowy-wydatek-nazwa-input")).sendKeys("TEST");

		expenseAddNewPage.typeIntoexpenseNAmeField("Telewizor");
		expenseAddNewPage.typeIntoCategoryField("Dom");
		expenseAddNewPage.typeIntoPriceField(String.valueOf(20.00));
		expenseAddNewPage.selectStatusOfExpense("Zaplanowany");
		expenseAddNewPage.pressAdd();

		Assert.assertTrue(expenseAddNewPage.okAllertIsDisplayed());
	}

}
