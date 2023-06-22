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
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Draganddrop {

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
		
		WebElement DragandDrop = driver.findElement(By.xpath("//android.widget.TextView[@text= 'Drag and Drop']"));
		
		tapactions.tap(TapOptions.tapOptions().withElement(ElementOption.element(DragandDrop))).perform();
		
		WebElement dragelement = driver.findElement(By.xpath("//android.view.View[@index= '4']"));
		
		WebElement dropelement = driver.findElement(By.xpath("//android.view.View[@index= '2']"));
	 
		// Dragelement
		int xcoordinatemiddledragelemnet  = dragelement.getLocation().x +( dragelement.getSize().width/2);
				
		int ycoordinatemiddledragelemnet  = dragelement.getLocation().y +( dragelement.getSize().height/2);
		
		// Dropelement
		int xcoordinatemiddleDropelemnet  = dragelement.getLocation().x +( dropelement.getSize().width/2);
				
		int ycoordinatemiddleDropelemnet  = dragelement.getLocation().y +( dropelement.getSize().height/2);
		
		tapactions.longPress(PointOption.point(xcoordinatemiddledragelemnet, ycoordinatemiddledragelemnet))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(xcoordinatemiddleDropelemnet, ycoordinatemiddleDropelemnet)).release().perform();
		
		driver.quit();
		}

}
