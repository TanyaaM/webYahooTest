package webtest.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.baseClass;

public class loginPage extends baseClass {
	
	
	@FindBy(xpath="(//*[text()='Sign in'])[1]")
	WebElement signIn ;
	@FindBy(xpath="//*[@name='username']")
	WebElement usernameField ;
	@FindBy(xpath="//*[@name='signin']")
	WebElement nextBtn ;
	@FindBy(xpath="//*[@type='password']")
	WebElement passwordField ;
	@FindBy(xpath="//*[@name='verifyPassword']")
	WebElement nextpasswordBtn ;
	@FindBy(xpath="//*[@id='ybarMailLink']")
	WebElement mailIcon ;
	
	public loginPage() {
		PageFactory.initElements(baseClass.driver,this);
	}
	
	
	
	public void loginMail() throws InterruptedException, IOException {
		signIn.click();
		String uName=validUsername();
		usernameField.sendKeys(uName);
		nextBtn.click();
		Thread.sleep(3000);
		String password=validPassword();
		passwordField.sendKeys(password);
		nextpasswordBtn.click();
	}
	public void clickMailIcon() {
		mailIcon.click();
	}
	
}
