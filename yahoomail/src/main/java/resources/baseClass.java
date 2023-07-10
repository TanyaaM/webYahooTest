package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

public class baseClass {
	
	public static WebDriver driver;
	
	public WebDriver initializeBrowser() throws IOException{
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream("D:\\assignment\\mobile\\yahoomail\\src\\main\\java\\resources\\GlobalData.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	if(browserName.equals("Chrome"))
	{
	System.out.println("Executing test in chrome browser");
	//change path
	System.setProperty("webdriver.chrome.driver", "D:\\assignment\\mobile\\yahoomail\\driver\\chromedriver.exe");
	driver=new ChromeDriver();

	}
	else if(browserName.equals("IE"))
	{
	System.out.println("Executing test in IE browser");
	System.setProperty("webdriver.ie.driver", "D:\\project\\Accolite\\drivers\\IEDriver.exe");
	driver=new InternetExplorerDriver();
	}
	else if(browserName.equals("firefox"))
	{
	System.out.println("Executing test in firefox browser");
	System.setProperty("webdriver.gecko.driver","D:\\project\\Accolite\\drivers\\geckodriver.exe");
	driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();

	return driver;
	}

 
	public String getURL() throws IOException {
		Properties prop= new Properties();
		//change path
		FileInputStream fis =new FileInputStream("D:\\assignment\\mobile\\yahoomail\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		String url=prop.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return url;
	}
	
	public String validUsername() throws IOException
	{
	Properties prop= new Properties();
	//change path
	FileInputStream fis =new FileInputStream("D:\\assignment\\mobile\\yahoomail\\src\\main\\java\\resources\\GlobalData.properties");
	prop.load(fis);
	String validUsername=prop.getProperty("username1");
	return validUsername;
	}

	public String username() throws IOException
	{
	Properties prop= new Properties();
	//change path
	FileInputStream fis =new FileInputStream("D:\\assignment\\mobile\\yahoomail\\src\\main\\java\\resources\\GlobalData.properties");
	prop.load(fis);
	String validUsername=prop.getProperty("username2");
	return validUsername;
	}
	
	public String recoveryEmailId() throws IOException
	{
	Properties prop= new Properties();
	//change path
	FileInputStream fis =new FileInputStream("D:\\assignment\\mobile\\yahoomail\\src\\main\\java\\resources\\GlobalData.properties");
	prop.load(fis);
	String recoveryEmailId=prop.getProperty("recoverEmailId");
	return recoveryEmailId;
	}
	public String validPassword() throws IOException
	{
	Properties prop= new Properties();
	//change path
	FileInputStream fis =new FileInputStream("D:\\assignment\\mobile\\yahoomail\\src\\main\\java\\resources\\GlobalData.properties");
	prop.load(fis);
	String validpassword=prop.getProperty("password");
	return validpassword;
	}
	
	public  void closeBrowser()
	{
	driver.close();
	}
	private void closeBrowser1() {
	    if (driver != null) {
	        try {
	            String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }
	}

}
