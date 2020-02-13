import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/*
 * 
 * This code will fill the form ,
 * navigate to the homepage
 * scroll down to the expected item and click add to cart button for the same.
 * It also checks the cart whether that item is added or not.
 * Also verifies that item selected on page 1 matches the item displayed on check out page
 * 
 */
public class Ecomm_TC_3 extends Base{

      public static void main(String[] args) throws MalformedURLException, InterruptedException {
						
	        AndroidDriver<AndroidElement> driver=capabilities();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Manas");
			driver.hideKeyboard();
			
		    driver.findElement(By.xpath("//*[@text='Female']")).click();
			driver.findElement(By.id("android:id/text1")).click();
			
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
//   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     
			driver.findElement(By.xpath("//*[@text='Argentina']")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			
			System.out.println("FORM FILLED");
			
//			Firstly identify the whole scrollable list then Scroll to the specific product "Jordan 6 Rings" from the
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
					+ "resourceId(\"com.androidsample.generalstore:id/rvProductList\"))."
					+ "scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
			
//	        Get the total count of items displayed on the screen		  
			int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
			for(int i=0;i<count;i++)
			{
//			If the text of the product at position (i)  is "Jordan 6 Rings" then click on "Add to Cart" for that product
			    String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			    if(text.equalsIgnoreCase("Jordan 6 Rings"))
			      {
			 
			        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			        break;
			      }
		    } 
			
			System.out.println("SCREEN SCROLLED AND ITEM SELECTED");
			
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			
			System.out.println("CLICKED ON THE CART TO VIEW THE SELECTED ITEM");
			
//          Verify that items displayed on page 2 is the item which was actually selected on page 1
			
			String lastpageText =    driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
			
			if("Jordan 6 Rings".equals(lastpageText))
			{
				System.out.println("ITEM ON CHECK OUT SCREEN MATCHES WITH THE ITEM SELECTED");
			}
			
						         
						
		}

}

