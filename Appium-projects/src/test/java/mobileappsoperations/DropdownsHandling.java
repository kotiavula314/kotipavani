package mobileappsoperations;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DropdownsHandling {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1" );
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy J3 (2016)");
		cap.setCapability("appPackge", "com.touchboarder.android.api.demos");
		cap.setCapability("appActivity", "com.example.android.apis.ApiDemos");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		WebElement viewsoptions = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		AndroidTouchAction touchoptions = new AndroidTouchAction(driver);
		touchoptions.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsoptions))).perform();
		
		
		WebElement autocomplete = driver.findElement(By.xpath("//android.widget.TextView[@text= 'Auto Complete']"));
		touchoptions.tap(TapOptions.tapOptions().withElement(ElementOption.element(autocomplete))).perform();
		
		
		
		WebElement screentop = driver.findElement(By.xpath("//android.widget.TextView[@text= '1. Screen Top']"));
		touchoptions.tap(TapOptions.tapOptions().withElement(ElementOption.element(screentop))).perform();
		
		
		WebElement country = driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit"));
		country.sendKeys("United");
		
		/*driver.findElement(ByAndroidUIAutomator("new UiScrollable(new Selector()"
				+ ".scrollable(true.instance(0)).scrollIntoView(new UiSelector().textContins("")"))*/
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
		action.sendKeys(Keys.DELETE);
		action.sendKeys(Keys.DOWN);
		action.sendKeys(Keys.DOWN);
		action.sendKeys(Keys.DOWN);
		action.sendKeys(Keys.ENTER);
		
	
	
		
		
		
		
		
		
		
		
		
		


	}

}
