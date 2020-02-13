import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/*
 * This code fills the form and navigates to the home page successfully
 * 
 */
public class Ecomm_TC_1 extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Gabon\"))").click();;
 /*     
  * 
  *     driver.findElement(MobileBy.AndroidUIAutomator
  *     ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
  */
	
		  
		
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Manas");
		
		driver.hideKeyboard();
		
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();;
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();;

	}

}
