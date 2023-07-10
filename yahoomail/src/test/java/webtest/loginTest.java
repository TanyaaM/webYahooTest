package webtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.GenericUtils;
import resources.baseClass;
import webtest.pageObjects.forgotPasswordPage;
import webtest.pageObjects.loginPage;
import webtest.pageObjects.newUserRegisterationPage;
import resources.GenericUtils;

public class loginTest extends baseClass {

		@Test(priority=1)
		public void loginToYahoo() throws IOException, InterruptedException {
			initializeBrowser();
			getURL();
			loginPage p =new loginPage();
			p.loginMail();
			String expectedHomePageTitle ="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
			String actualHomePageTitle =driver.getTitle();
			System.out.println(actualHomePageTitle);
			Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle, "Unsuccessful login");
			p.clickMailIcon();
			closeBrowser();
		}
		
		@Test(priority=2)
		public void forgotPassword() throws IOException, InterruptedException {
			initializeBrowser();
			getURL();
			forgotPasswordPage fp =new forgotPasswordPage();
			String newPassword=GenericUtils.generateRandomPassword(12);
			fp.setNewPassword(newPassword);
			WebElement successMsg=fp.successMessage();
			GenericUtils.verifyElementIsVisible(driver, successMsg);
			String actualSuccessMessage =successMsg.getText();
			System.out.println("Password is updated successfully "+actualSuccessMessage);
			WebElement continueBtn =fp.continueAgainButton();
			continueBtn.click();
			WebElement looksGoodBtn =fp.looksGoodButton();
			GenericUtils.verifyElementIsVisible(driver, looksGoodBtn);
			looksGoodBtn.click();
			String expectedLandingPageTitle ="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
			String actualLandingPageTitle =driver.getTitle();
			System.out.println(actualLandingPageTitle);
			Assert.assertEquals(actualLandingPageTitle, expectedLandingPageTitle, "Unsuccessful Password update");
			closeBrowser();	
		}
		
		@Test(priority=3)
		public void createNewUser() throws IOException, InterruptedException {
			initializeBrowser();
			getURL();
			newUserRegisterationPage ur =new newUserRegisterationPage();
			String emailId=GenericUtils.generateRandomUsername();
			ur.createAccount(emailId);
			String actualLandingPageTitle =driver.getTitle();
			String expectedLandingPageTitle ="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
			System.out.println(actualLandingPageTitle);
			Assert.assertEquals(actualLandingPageTitle, expectedLandingPageTitle, "Unsuccessful Account Creation");
			closeBrowser();	
		}

}
