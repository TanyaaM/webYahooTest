package webtest.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.baseClass;

public class forgotPasswordPage extends baseClass {

	@FindBy(xpath="(//*[text()='Sign in'])[1]")
	WebElement signIn ;
	
	@FindBy(xpath="//*[@name='username']")
	WebElement usernameField ;
	
	@FindBy(xpath="//*[@name='signin']")
	WebElement nextBtn ;
	
	@FindBy(xpath="//*[@name='skip']")
	WebElement forgotPasswordLink ;
	
	@FindBy(xpath="//*[@type='password']")
	WebElement nextpasswordBtn ;
	
	@FindBy(xpath="(//*[contains(text(),'Email')]/following::button[@type='submit'])[1]")
	WebElement emailCodeBtn ;
	
	@FindBy(xpath="//*[@name='email']")
	WebElement recoveryMailField ;
	
	@FindBy(xpath="//*[@name='verifyEmail']")
	WebElement sendBtn ;
	
	@FindBy(xpath="//*[@type='password']")
	WebElement newPasswordField ;
	
	@FindBy(xpath="//*[@name='verifyCode']")
	WebElement verifyCodeBTn ;
	
	@FindBy(xpath="//*[@value='Continue']")
	WebElement continueBtn ;
	
	@FindBy(xpath="(//*[text()='Success!']/following-sibling::*)[1]")
	WebElement successMsg ;
	
	@FindBy(xpath="//*[text()='Continue']")
	WebElement continueAgainBtn ;
	
	@FindBy(xpath="//*[@name='confirmCommChannels']")
	WebElement looksGoodBtn ;
	
	
	public forgotPasswordPage() {
		PageFactory.initElements(baseClass.driver,this);
	}
	
	public void setNewPassword(String newPassword) throws InterruptedException, IOException {
		signIn.click();
		String uName=username();
		usernameField.sendKeys(uName);
		nextBtn.click();
		Thread.sleep(3000);
		forgotPasswordLink.click();
		emailCodeBtn.click();
		String recoveryEmailId =recoveryEmailId();
		recoveryMailField.sendKeys(recoveryEmailId);
		sendBtn.click();
		Thread.sleep(30000);
		verifyCodeBTn.click();
		newPasswordField.sendKeys(newPassword);
		Thread.sleep(2000);
		continueBtn.click();		
	}
	
	public WebElement successMessage() {
		return successMsg;
		
	}
	public WebElement looksGoodButton() {
		return looksGoodBtn;
		
	}
	public WebElement continueAgainButton() {
		return continueAgainBtn;
		
	}
	
	
}
