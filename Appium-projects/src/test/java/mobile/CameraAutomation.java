package mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class CameraAutomation {
	public static DesiredCapabilities cap;
	public static AndroidDriver driver;
	public static AndroidTouchAction touch;
	public static void camlaunch() throws MalformedURLException {
	cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy J3 (2016)");
	cap.setCapability("appPackage", "com.sec.android.app.launcher");
	cap.setCapability("appActivity", "com.android.launcher2.Launcher");
	URL url = new URL("http://0.0.0.0:4723/wd/hub");
	 driver = new AndroidDriver(url,cap);
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement camera = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Camera\"]"));
	 touch = new AndroidTouchAction(driver);
	touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(camera))).perform();
	WebElement camera1 = driver.findElement(By.xpath("//GLButton[@content-desc=\"MENUID_RECORDING\"]"));
	touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(camera1))).perform();
	}
	
	public static void main(String[] args) throws MalformedURLException {
		CameraAutomation.camlaunch();
	}

}
