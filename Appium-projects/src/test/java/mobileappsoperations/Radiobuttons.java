package mobileappsoperations;

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

public class Radiobuttons {

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

		
		WebElement viewsoption = driver.findElement(By.xpath("//android.widget.TextView[@text= 'Views']"));
		
		AndroidTouchAction tapactions = new AndroidTouchAction(driver);
		tapactions.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsoption))).perform();
		
		WebElement controls = driver.findElement(By.xpath("//android.widget.TextView[@text='Controls']"));
		tapactions.tap(TapOptions.tapOptions().withElement(ElementOption.element(controls))).perform();
		
		WebElement customtheame = driver.findElement(By.xpath("//android.widget.TextView[@text= '07. Custom Theme']"));
		tapactions.tap(TapOptions.tapOptions().withElement(ElementOption.element(customtheame))).perform();
		
		
		WebElement textbox = driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit"));
		textbox.sendKeys("koteswaraRao");
		
		WebElement radiobutton = driver.findElement(By.xpath("//android.widget.RadioButton[@index = '0']"));
		radiobutton.click();
		
		WebElement checkhbox = driver.findElement(By.xpath("//android.widget.CheckBox[@index = '3']"));
		checkhbox.click();
	
		driver.quit();
		
		
		
	

	}

}
