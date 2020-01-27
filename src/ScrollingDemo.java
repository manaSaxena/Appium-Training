import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollingDemo extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
//		click on Views
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
/*
 * 		Scroll until Radio Group option is visible.
 *      Appium does not provides any direct method for scroll.. its simple android api code.
 * 
 */

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"))");
	}

}
 