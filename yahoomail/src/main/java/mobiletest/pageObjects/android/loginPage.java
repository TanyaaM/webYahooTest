package mobiletest.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage {
	
	AndroidDriver driver;
	
	public loginPage(AndroidDriver driver) {
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
 
	@AndroidFindBy(xpath="//*[@class = 'android.widget.Button' and @resource-id = 'com.yahoo.mobile.client.android.mail:id/yahoo_sign_in_link']")
	private WebElement signInButton;
	
	@AndroidFindBy(xpath="//*[@class = 'android.widget.EditText' and @resource-id = 'login-username']")
	private WebElement usernameField;
	
	@AndroidFindBy(xpath="//*[@class = 'android.widget.Button' and (@text = 'Next') and @resource-id = 'login-signin']")
	private WebElement nextButton;
	
	@AndroidFindBy(xpath="//*[@class = 'android.widget.EditText' and @resource-id = 'login-passwd']")
	private WebElement passwordField;
	
	@AndroidFindBy(xpath="//*[@class = 'android.widget.TextView' and (@text = 'Mail' or . = 'Mail') and @resource-id = 'com.yahoo.mobile.client.android.mail:id/toolbar_title']")
	private WebElement InboxText;
	
	
	public void tapSignIn() {
		signInButton.click();
	}
	public void setUsername(String username) {
		usernameField.sendKeys(username);
	}
	public void tapNextButton() {
		nextButton.click();
	}
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
}
