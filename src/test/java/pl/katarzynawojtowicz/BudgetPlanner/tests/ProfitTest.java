package pl.katarzynawojtowicz.BudgetPlanner.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pl.katarzynawojtowicz.BudgetPlanner.config.DriverUtils;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.ExpenseSearchListPage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.HomePage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.LoginPage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.ProfitAddNewPage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.ProfitSearchListPage;
import pl.katarzynawojtowicz.BudgetPlanner.pageobjects.TablePage;

public class ProfitTest extends AbstractBaseTest {
	
	@Test
	public void positiveAddNewProfit() {
		HomePage homePage = new HomePage(driver);
		homePage.pressLoginLink();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithCredentials(CORRECT_LOGIN, CORRECT_PASSWORD);
		ExpenseSearchListPage expenseSearchPage = new ExpenseSearchListPage(driver);
		
		expenseSearchPage.goToProfitAddNewPage();
		ProfitAddNewPage profitAddNewPage = new ProfitAddNewPage(driver);
		
		profitAddNewPage.putNameToField("wynagrodzenie");
		profitAddNewPage.putAmountToField("10000");
		profitAddNewPage.putDateToField("01.04.2020");
		
		
		profitAddNewPage.clickOnAddButton();

		
		Assert.assertTrue(profitAddNewPage.alertIsVisible());
		
	}
	
	@Test 
	public void negativeAddNewProfit() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.pressLoginLink();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithCredentials(CORRECT_LOGIN, CORRECT_PASSWORD);
		ExpenseSearchListPage expenseSearchPage = new ExpenseSearchListPage(driver);
		
		expenseSearchPage.goToProfitAddNewPage();
		ProfitAddNewPage profitAddNewPage = new ProfitAddNewPage(driver);
		
		profitAddNewPage.putNameToField("wynagrodzenie");
		profitAddNewPage.putAmountToField("10000");
	
		profitAddNewPage.clickOnAddButton();
		profitAddNewPage.clickOnAddButton();
		
		Thread.sleep(3000);
		Assert.assertTrue(profitAddNewPage.errorIsVisible());
		
	}

	
	@Test
	public void positiveDeleteProfit() {
		HomePage homePage = new HomePage(driver);
		homePage.pressLoginLink();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithCredentials(CORRECT_LOGIN, CORRECT_PASSWORD);
		
		ProfitSearchListPage profitSearchPage = new ProfitSearchListPage(driver);
		
		TablePage profitList = profitSearchPage.getProfitList();
		
		String firstIdBeforeDelete = profitList.getCellText(0, 0);
		profitList.clickOnRow(0);
		profitSearchPage.deleteProfit();
		String firstIdAfterDelete = profitList.getCellText(0, 0);
		
		Assert.assertNotEquals(firstIdBeforeDelete, firstIdAfterDelete);
	}
	
}
