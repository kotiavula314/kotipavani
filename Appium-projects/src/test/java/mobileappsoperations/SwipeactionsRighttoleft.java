package mobileappsoperations;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.implementation.bytecode.StackManipulation.Size;

public class SwipeactionsRighttoleft {
	
	public static DesiredCapabilities  cap;
	public static AndroidDriver driver;
	
	public  static void clickaction() throws MalformedURLException
	{
		  cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy J3(2016)");
		cap.setCapability("appPackage", "com.sec.android.app.launcher");
		cap.setCapability("appActivity", "com.android.launcher2.Launcher");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		 driver = new AndroidDriver(url,cap);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Apps\"]"));
		AndroidTouchAction tap =new AndroidTouchAction(driver);
		tap.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();
			
	}
	
	public static  void doubleswipe()
	{
		
	WebElement koti = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TabHost/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.View"));
		
		Dimension size = koti.getSize();
		int Anchor = koti.getSize().getHeight()/2;
				
		Double Screenwidthstart = size.getWidth()*0.99;
		int scrollstart = Screenwidthstart.intValue();
		
				
		Double Screenwidthend = size.getWidth()*0.1;
		int scrollEnd = Screenwidthstart.intValue();
		
		new TouchAction((PerformsTouchActions)driver).press(PointOption.point(scrollstart,Anchor ))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(scrollEnd, Anchor)).release().perform();
		
	}
	public static void main(String[] args) throws Exception {
		SwipeactionsRighttoleft.clickaction();
		SwipeactionsRighttoleft.doubleswipe();
		}

}
