package resources;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.Random;

public class GenericUtils {

	/*
	 * This function will select the value from index on the basis of index ,it takes one parameter i.e index value
	 */
	public static void SelectByIndex(WebElement element, int index)
	{
	Select sel=new Select(element);
	sel.selectByIndex(index);
	}

	public static void getScreenshot(WebDriver driver)
	{
	try
	{
	TakesScreenshot t=(TakesScreenshot)driver;
	File src=t.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshots.png");
	//FileUtils.copyFile(src,dest);

	}
	catch(Exception e)
	{

	}}
	
	/*
	 * This function verifies the element is visible on the screen
	 */
	public static void verifyElementIsVisible(WebDriver driver,WebElement  element)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	try
	{
	wait.until(ExpectedConditions.visibilityOf(element));
	Reporter.log("Element is present",true);
	}
	catch(Exception e)
	{
	Reporter.log("Element is not present",true);
	Assert.fail();
	}
	}
	
	/*
	 * This function generate a random password 
	 */
	public static String generateRandomPassword(int length) 
	{
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
	/*
	 * This function generates random username
	 */
	 public static String generateRandomUsername() {
	        String[] adjectives = {
	                "android",
	                "ios",
	                "macos",
	                "mac",
	                "window",
	                "ipad",
	                "iphone",
	                "tab",
	                "macbook"
	        };
	        String[] nouns = {
	                "test",
	                "web",
	                "android",
	                "mweb",
	                "testweb",
	                "testmobile",
	                "automation",
	                "functional",
	                "ios"
	        };

	        Random random = new Random();
	        String adjective = adjectives[random.nextInt(adjectives.length)];
	        String noun = nouns[random.nextInt(nouns.length)];
	        int number = random.nextInt(100);

	        return adjective + noun + number;
	    }

}
