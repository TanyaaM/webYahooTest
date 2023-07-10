package webtest.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.GenericUtils;
import resources.baseClass;

public class newUserRegisterationPage extends baseClass {
	
	
	@FindBy(xpath="(//*[text()='Sign in'])[1]")
	WebElement signInLink ;
	
	@FindBy(xpath="//*[@id='createacc']")
	WebElement createAccountLink ;
	
	@FindBy(xpath="//*[@name='lastName']")
	WebElement lastNameField ;
	
	@FindBy(xpath="//*[@name='firstName']")
	WebElement firstNameField ;
	
	@FindBy(xpath="//*[@name='userId']")
	WebElement emailField ;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement passwordField ;
	
	@FindBy(xpath="//*[@name='mm']")
	WebElement monthList ;
	
	@FindBy(xpath="//*[@name='dd']")
	WebElement dayField ;
	
	@FindBy(xpath="//*[@name='yyyy']")
	WebElement yearField ;
	
	@FindBy(xpath="//*[@name='signup']")
	WebElement continueBtn ;
	
	@FindBy(xpath="//*[@name='phone']")
	WebElement phoneField ;
	
	@FindBy(xpath="//*[@type='submit' and contains(text(),'Done')]")
	WebElement doneButton ;
	
	public newUserRegisterationPage() {
		PageFactory.initElements(baseClass.driver,this);
	}
	
	
	
	public void createAccount(String emailId) throws InterruptedException, IOException {
		signInLink.click();
		createAccountLink.click();
		firstNameField.sendKeys("test");
		lastNameField.sendKeys("bt");
		emailField.sendKeys(emailId);
		passwordField.sendKeys("Automation@2023");
		GenericUtils.SelectByIndex(monthList, 2);
		dayField.sendKeys("1");
		yearField.sendKeys("1990");
		continueBtn.click();
		phoneField.sendKeys("1234567890");
		continueBtn.click();
		Thread.sleep(30000);
		doneButton.click();
		
	}
}
