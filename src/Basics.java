import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomepageScreen;
import pageObjects.PreferenceDependenciesScreen;
import pageObjects.PreferenceScreen;

public class Basics extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();		
		HomepageScreen h = new HomepageScreen(driver);
		h.preferencesElement.click();
		
		
//		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		PreferenceScreen p = new PreferenceScreen(driver);
		p.dependenciesElement.click();
		
		
		PreferenceDependenciesScreen pd = new PreferenceDependenciesScreen(driver);
		pd.checkBoxElement.click();
		pd.textElement.click();
		pd.editBoxElement.sendKeys("Hello");
		pd.buttons.get(1).click();
//		driver.findElementById("android:id/checkbox").click();
//		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
//		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
//		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
	}

}
