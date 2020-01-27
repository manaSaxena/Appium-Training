import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SwipeDemo extends Base{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		click on Views
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
//		Click on Date Widgets
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		
//		Click on Inline
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		
//		Click on 9
		driver.findElementByXPath("//*[@content-desc='9']").click();;
		
//		first element in the clock number 15 and second is 45 [swiping from 15 to 45]
		WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
		
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();	
		
		
		
	}

}
