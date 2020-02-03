import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

/*
 * This code will launch chrome browser in the connect mobile device
 * 
 */
public class BaseChrome {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		
 
/*		File f = new File("APP");
		File fs = new File(f,"ApiDemos-debug.apk");*/
		DesiredCapabilities cap = new DesiredCapabilities();
		
//		Lenovo K4 NOTE - SSWS4DNR4SZPQWRW
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");	
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");			
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step
		
/*		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());*/
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);	
		return driver;
	}

}