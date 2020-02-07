import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class CricbuzzMobile extends BaseChrome{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		
//		navigate to cricbuzz , tap on menu, then tap again on Home
		driver.get("http://cricbuzz.com");
		driver.findElementByXPath("//a[@href='#menu']").click();
		driver.findElementByXPath("//a[@title='Cricbuzz Home']").click();
		System.out.println(driver.getCurrentUrl());

//		scroll and verify Top Stories is a header text
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");
//		Assert.assertTrue(driver.findElementByXPath("//h4[text()='Top Stories']").getAttribute("class").contains("header"));
		
		if(driver.findElementByXPath("//h4[text()='Top Stories']").getAttribute("class").contains("header")== true)
		{
			System.out.println("Top Stories is a header text");
		}
		
	}
/*
 * adb devices - unauthorized
 * adb kill-server
 * adb start-server
 * adb devices
 * 
 */
}


