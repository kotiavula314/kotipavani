package mobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchGooglechrome {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1" );
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy J3(2016)");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,cap);
		driver.get("https://www.aiimsbilaspur.edu.in/");




	}

}
