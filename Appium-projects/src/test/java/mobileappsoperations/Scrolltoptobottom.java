package mobileappsoperations;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Scrolltoptobottom {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1" );
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy J3 (2016)");
		cap.setCapability("appPackge", "com.sec.android.app.launcher");
		cap.setCapability("appActivity", "com.android.launcher2.Launcher");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
	

		WebElement viewsoptions = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		
		AndroidTouchAction touchoptions = new AndroidTouchAction(driver);
		touchoptions.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsoptions))).perform();



		//List<WebElement> list = driver.findElements(By.xpath("//android.widget.TextView[@text= 'Lists']"));

		WebElement listem = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"WebView\"))"));

		System.out.println(listem.getLocation());

		listem.click();






	}

}
