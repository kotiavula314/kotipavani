package appiumlocators;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import mobileappsoperations.Touchaction;

public class Resourceid {
	public static DesiredCapabilities cap;
	public static AndroidDriver driver;
	public static AndroidTouchAction touch;
	public static void Launchpad() throws MalformedURLException
	{
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy J3 (2016)");
		cap.setCapability("appPackage", "com.sec.android.app.launcher");
		cap.setCapability("appActivity", "com.android.launcher2.Launcher");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		 driver = new AndroidDriver(url,cap);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement Apps = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Apps\"]"));
		 touch = new AndroidTouchAction(driver);
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(Apps))).perform();
	}
	public static void  horizontalswipe()
	{
		WebElement AppsGrid = driver.findElement(By.id("com.sec.android.app.launcher:id/apps_grid"));
		Dimension dimension = AppsGrid.getSize();
		int Anchor = AppsGrid.getSize().getHeight()/2;
		
		Double Screenstart =dimension.width*0.99;
		int Screenstart1 = Screenstart.intValue();
		
		Double Screenend = dimension.width*0.1;
		int Screenend1 = Screenend.intValue();
		
		new TouchAction((PerformsTouchActions)driver).press(PointOption.point(Screenstart1, Anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(20)))
		.moveTo(PointOption.point(Screenstart1, Anchor)).release().perform();
		
		WebElement apidemos = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"API Demos\"]"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(apidemos))).perform();
		
		WebElement apidemos12 = driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(apidemos12))).perform();
		apidemos12.click();
		
	}
	
	public static  void apidemosappscroldown()
	{
		WebElement listem = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator
				("new UiScrollable(new UiSelector())"
				+ ".scrollIntoView(" + "new UiSelector().text(\"Views\"))"));
		listem.click();
	}
	
	public static void main(String[] args) throws MalformedURLException {
		
		Resourceid.Launchpad();
		Resourceid.horizontalswipe();
		Resourceid.apidemosappscroldown();
		
	}

}
