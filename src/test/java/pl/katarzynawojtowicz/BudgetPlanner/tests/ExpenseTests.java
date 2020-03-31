package pl.katarzynawojtowicz.BudgetPlanner.tests;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;

import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.ExpenseAddNewPage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.ExpenseSearchListPage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.HomePage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.LoginPage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.TablePage;

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

	@Test
	public void positiveDeleteExpense() {
		HomePage homePage = new HomePage(driver);
		homePage.pressLoginLink();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithCredentials(CORRECT_LOGIN, CORRECT_PASSWORD);
		ExpenseSearchListPage expenseSearchPage = new ExpenseSearchListPage(driver);

		TablePage expenseList = expenseSearchPage.getExpenseList();
		String firstIdBeforeDelete = expenseList.getCellText(0, 0);
		expenseList.clickOnRow(0);
		expenseSearchPage.deleteExpense();
		String firstIdAfterDelete = expenseList.getCellText(0, 0);

		Assert.assertNotEquals(firstIdBeforeDelete, firstIdAfterDelete);
	}

}
