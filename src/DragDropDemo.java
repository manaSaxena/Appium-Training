import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.DragAndDropScreen;
import pageObjects.HomepageScreen;
import pageObjects.ViewsScreen;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class DragDropDemo extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		click on Views
//		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		HomepageScreen h = new HomepageScreen(driver);
		h.viewsElement.click();
		
//		Click on Drag n Drop menu
//		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		ViewsScreen vs = new ViewsScreen(driver);
		vs.dragDropElement.click();
		
//		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
//		WebElement destination = driver.findElementsByClassName("android.view.View").get(1);
		DragAndDropScreen dd = new DragAndDropScreen(driver);
		WebElement source=dd.circleElement.get(0);
		WebElement destination=dd.circleElement.get(1);
		
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
		
		
/*
 * 		If we have to perform multiple option on a long press then use the above statement...
 * 		other wise longPressOptions can be skipped and we ca use the below code.
 *  	t.longPress(element(source))).moveTo(element(destination)).release().perform();
 */

	}

}
