import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomator extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		
//		C:\Users\MANAS\AppData\Local\Android\Sdk\tools\bin
//		C:\Program Files (x86)\Android\android-sdk\tools\tools\bin    
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElementByAndroidUIAutomator("attribute("value")")
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		
//		Validate clickable feature for all the options
//		driver.findElementByAndroidUIAutomator("new UiSelector().attribute(value)
		System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)").getSize());
		
		
		

	}

}
