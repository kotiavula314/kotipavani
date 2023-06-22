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
import io.appium.java_client.touch.offset.ElementOption;

public class ScrollBar {
	public static AndroidTouchAction tap;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap =new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy J3(2016)");
		cap.setCapability("appPackage", "com.sec.android.app.launcher");
		cap.setCapability("appActivity", "com.android.launcher2.Launcher");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Apps\"]")).click();
		tap = new AndroidTouchAction(driver);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Clock\"]")).click();
		driver.findElement(By.id("com.sec.android.app.clockpackage:id/custom_create_button_alarm")).click();
		
		WebElement volumescrollbar = driver.findElement(By.id("com.sec.android.app.clockpackage:id/alarm_volume"));
		String volumescrollbarposition = driver.findElement(By.id("com.sec.android.app.clockpackage:id/alarm_volume")).getText();
		System.out.println("The current position of scroll bar is "    +volumescrollbarposition);
		
		tap.longPress(ElementOption.element(volumescrollbar)).moveTo(ElementOption.element(volumescrollbar, 1000, 1000)).release().perform();
		
		String volumescrollbarposition1 = driver.findElement(By.id("com.sec.android.app.clockpackage:id/alarm_volume")).getText();
		System.out.println("The current position of scroll bar is "    +volumescrollbarposition1);
		
	}

}
