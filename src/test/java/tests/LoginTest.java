package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void testLoginWithInvalidCredentials () throws InterruptedException {

		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test  with Invalid Credentials");
		test.info("Navigating to URL");

		LoginPage loginPage = new LoginPage(driver);

		Log.info("Adding credentials...");
		test.info("Adding Credentials");
		loginPage.enterUserName("admin@yourstore.com");
		loginPage.enterPassword("admin123");
		test.info("Clicking om Login button");
		loginPage.clickLogin();
		
		Thread.sleep(5000);
	

		System.out.println("Заголовок этой страницы: " + driver.getTitle());
		Log.info("Verifying page title...");
		test.info("Verifing page title");
		Assert.assertEquals(driver.getTitle(), "Один момент…");

		test.pass("Login Successful");

	}

	@Test
	public void testValidLogin() {

		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test");
		test.info("Navigating to URL");

		LoginPage loginPage = new LoginPage(driver);

		Log.info("Adding credentials...");
		test.info("Adding Credentials");
		loginPage.enterUserName("admin@yourstore.com");
		loginPage.enterPassword("admin");
		test.info("Clicking om Login button");
		loginPage.clickLogin();

		System.out.println("Заголовок этой страницы: " + driver.getTitle());
		Log.info("Verifying page title...");
		test.info("Verifing page title");
		Assert.assertEquals(driver.getTitle(), "Один момент…");

		test.pass("Login Successful");

	}

}
