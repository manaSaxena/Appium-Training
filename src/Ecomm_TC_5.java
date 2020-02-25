import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/*
 * Tap and Long Press on the check out screen, then visit to the browser
 * Perform operation in the Web browser
 */

public class Ecomm_TC_5 extends Base 
{

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Manas");		
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		System.out.println("Logged in");
		
//		capturing all the elements from the product list and adding first 2 item to the cart
		List<AndroidElement> prodList = driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']");
		for(int i = 0; i<=1; i++)
			prodList.get(i).click();
		
		System.out.println("Clicked on ADD TO CART");
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		System.out.println("Navigated to Check Out screen");
		
		Thread.sleep(4000);
		
//		Tap on the check box
//		WebElement chckbox = driver.findElementByClassName("android.widget.CheckBox");
		WebElement chckbox = driver.findElementByAndroidUIAutomator("className(\"android.widget.CheckBox\")");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(chckbox))).perform();
		System.out.println("Check Box Selected");
		
//		Long Press on the T&C
		WebElement tnCLink = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
		t.longPress(longPressOptions().withElement(element(tnCLink)).withDuration(ofSeconds(2))).release().perform();
		System.out.println("T&C pop up displayed");
		
		driver.findElementById("android:id/button1").click();
		System.out.println("Clicked on Close button");
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		System.out.println("Clicked on visit website button - Browser displayed");
		
//		working on WEBVIEW - Hybrid app
		Thread.sleep(7000);
		
		Set<String> contextHandles = driver.getContextHandles();
		for (String handles : contextHandles)
			System.out.println(handles);
		
//	    Switching to WEB VIEW	
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Manas Saxena");
		driver.findElement(By.xpath("//button[@aria-label='Google Search']")).click();
		
//		Navigate back to Native App
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		System.out.println("Back to the native app");
		
		
		
		
		
		
		
	}
}