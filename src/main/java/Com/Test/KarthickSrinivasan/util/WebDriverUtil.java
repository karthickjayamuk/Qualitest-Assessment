package Com.Test.KarthickSrinivasan.util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtil{
	
private static WebDriver webDriver;

	
public void setWebDriver(String browser) {
	if(browser.equals("Chrome")) {
	System.setProperty("webdriver.chrome.driver", getDriverPath(browser));
	webDriver = new ChromeDriver();	
	webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
	
public static WebDriver getWebdriver() {
	return webDriver;
}

public String getDriverPath(String browser) {
	if(browser.equals("Chrome")) {
		return  System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"lib"+File.separator+"webdrivers"+File.separator+"chromedriver.exe";
	}
	
	return null;
	
}

}
