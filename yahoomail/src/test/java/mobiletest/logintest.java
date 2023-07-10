package mobiletest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import mobiletest.pageObjects.android.loginPage;

import java.net.MalformedURLException;

public class logintest extends BaseTest {

	@Test
	public void appiumTest() throws MalformedURLException, InterruptedException {
//		loginPage lp =new loginPage(driver);
//		lp.tapSignIn();
//		lp.setUsername("tanyamahajan06@yahoo.com");
//		lp.tapNextButton();
//		lp.setPassword("M@gicworld06");
//		lp.tapNextButton();
		driver.findElement(By.xpath("//*[@class = 'android.widget.Button' and @resource-id = 'com.yahoo.mobile.client.android.mail:id/yahoo_sign_in_link']")).click();
		Thread.sleep(15000);
		//driver.findElement(By.xpath("//*[@class = 'android.widget.EditText' and @resource-id = 'login-username']/following-sibling::*")).sendKeys("tanya.mahajan@yahoo.com");
		driver.findElement(By.xpath("//*[@class = 'android.widget.TextView' and (@text = 'Forgotten username?' or . = 'Forgotten username?')]")).click();
	//	driver.findElement(By.xpath("//*[@resource-id = 'login-username']")).sendKeys("sdfghjkl");
		
		Thread.sleep(5000);
		
		
    }
}
////he is pushing me to add more experience in api rest assured 
	

