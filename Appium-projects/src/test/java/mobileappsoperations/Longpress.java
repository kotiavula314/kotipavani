package mobileappsoperations;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Longpress {

	public static void main(String[] args) throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy J3 (2016)");
		cap.setCapability("appPackge", "com.touchboarder.android.api.demos");
		cap.setCapability("appActivity", "com.example.android.apis.ApiDemos");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		AndroidDriver driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		WebElement tap = driver.findElement(By.xpath("//android.widget.TextView[@text= 'Views']"));
		
		AndroidTouchAction tapoption =new AndroidTouchAction(driver);
		tapoption.tap(TapOptions.tapOptions().withElement(ElementOption.element(tap))).perform();
		
		WebElement tap1 = driver.findElement(By.xpath("//android.widget.TextView[@text= 'Expandable Lists']"));
		tapoption.tap(TapOptions.tapOptions().withElement(ElementOption.element(tap1))).perform();
		
		WebElement tap2 = driver.findElement(By.xpath("//android.widget.TextView[@text= '1. Custom Adapter']"));
		tapoption.tap(TapOptions.tapOptions().withElement(ElementOption.element(tap2))).perform();
		
		WebElement longpressaction = driver.findElement(By.xpath("//android.widget.TextView[@text= 'People Names']"));
		
		LongPressOptions lpress = new LongPressOptions();
		lpress.withDuration(Duration.ofSeconds(5)).withElement(ElementOption.element(longpressaction));
		tapoption.longPress(lpress).release().perform();
		
		


	}

}
