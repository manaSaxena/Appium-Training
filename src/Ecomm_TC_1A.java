import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/*
 * This code verifies the error toast message
 * 
 */
public class Ecomm_TC_1A extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Gabon\"))").click();
	  
		
//		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Manas");
		
		driver.hideKeyboard();
		
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
//		Use this code for verifying the toast, as toast can not be inspected
		String errorMsg = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println(errorMsg);
		

	}

}
