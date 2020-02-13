import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/*
 * This code fills the form and navigates to the home page successfully
 * selects 2 products 
 * then verify the sum of prices of both the products is equal to the total amount - Lecture 58
 */
public class Ecomm_TC_4 extends Base 
{

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
 /*      
  *     driver.findElement(MobileBy.AndroidUIAutomator
  *     ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
  */
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Manas");		
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
//		capturing all the elements from the product list and adding first 2 item to the cart
		List<AndroidElement> prodList = driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']");
			for(int i = 0; i<=1; i++)
			{
				prodList.get(i).click();
				
			}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		
//      capturing the price of both selected products on the check out screen
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

		double sum=0;
	        for(int i=0;i<count;i++)
	        {
	            	String strAmount= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
					double dblAmount=getAmount(strAmount);
					sum = sum + dblAmount;//280.97+116.97
	        }

		System.out.println(sum+" sum of products");
		
//      capturing the total price
		String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

/*		total = total.substring(1);
		double totalValue=Double.parseDouble(total);*/

		double totalValue=getAmount(totalAmount);
		
		System.out.println(totalValue+" Total value of products");
				 
	}

	public static double getAmount(String value)
	{

		value= value.substring(1);	
		double dblAmount=Double.parseDouble(value);		
		return dblAmount;
	}
}