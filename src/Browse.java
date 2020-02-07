import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/*
 * 
 * This code will automate the mobile chrome browser
 * navigate to facebook
 * and check for an invalid login
 */


public class Browse extends BaseChrome {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.get("http://www.facebook.com");
		
		driver.findElementByXPath("//*[@id='m_login_email']").sendKeys("manas");
		driver.findElementByXPath("//*[@id='m_login_password']").sendKeys("password");		
		driver.findElementByXPath("//button[@value='Log In']").click();
		

	}

}
