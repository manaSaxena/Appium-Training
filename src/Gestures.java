import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static java.time.Duration.ofSeconds;

public class Gestures extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		click on Views
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
//		Tap on Expand Lists element
		WebElement expandLists = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(expandLists))).perform();
		
//		Tap on Custom adaptor element
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();;
//		Long Press on People names element
		WebElement peopleNames = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
		t.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();
		
		Thread.sleep(2000);
		System.out.println(driver.findElementById("android:id/alertTitle").isDisplayed());


	}

}
