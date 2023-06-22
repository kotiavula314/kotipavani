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

public class SwitchesHandlings {
public static AndroidTouchAction tap;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Clock\"]")).click();
		driver.findElement(By.id("com.sec.android.app.clockpackage:id/custom_create_button_alarm")).click();

		WebElement switchelement =driver.findElement(By.id("com.sec.android.app.clockpackage:id/alarm_snooze_switch"));
		tap = new AndroidTouchAction(driver);
		tap.tap(TapOptions.tapOptions().withElement(ElementOption.element(switchelement))).perform();
		String switchstatus = driver.findElement(By.id("com.sec.android.app.clockpackage:id/alarm_snooze_switch")).getText();
		System.out.println("The status of the switch is "  +switchstatus);
		Thread.sleep(3000);
		WebElement switchelement1 =driver.findElement(By.id("com.sec.android.app.clockpackage:id/alarm_snooze_switch"));
		tap.tap(TapOptions.tapOptions().withElement(ElementOption.element(switchelement1))).perform();
		Thread.sleep(3000);
		String switchstatus1 = driver.findElement(By.id("com.sec.android.app.clockpackage:id/alarm_snooze_switch")).getText();
		System.out.println("The status of the switch is "  +switchstatus1);
	}

}
