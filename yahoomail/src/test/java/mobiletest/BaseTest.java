package mobiletest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException , InterruptedException
	{

		DesiredCapabilities capabilities = new DesiredCapabilities();
	    // Set device information
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus");
	    capabilities.setCapability(MobileCapabilityType.UDID, "a425992f");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");

	    // Set app information
	    capabilities.setCapability(MobileCapabilityType.APP, "D://assignment//mobile//yahoomail//src//test//java//resources"
	    		+ ""
	    		+ ""
	    		+ "\\yahoo.apk");
	     driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
//AppiumDriverLocalService service =new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Tanya//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
//.withIPAddress("127.0.0.1").usingPort(4723).build();
//
//service.start();
