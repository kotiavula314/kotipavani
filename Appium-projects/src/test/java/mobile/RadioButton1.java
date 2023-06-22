package mobile;

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

public class RadioButton1 {
	
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
	public static void screen1()
	{
		WebElement scrrengrid = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TabHost/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.View"));
		Dimension dimesnsion = scrrengrid.getSize();//get page size
		int Anchor = scrrengrid.getSize().getHeight()/2;
		
		Double Scrollwidthstart = dimesnsion.width*0.99;
		int Scrollwidthstarts1= Scrollwidthstart.intValue();
		
		
		Double screensendwidthend = dimesnsion.getWidth()*0.1;
		int screensendwidthend1 = screensendwidthend.intValue();
		
		new TouchAction((PerformsTouchActions)driver).press(PointOption.point(Scrollwidthstarts1, Anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(screensendwidthend1, Anchor)).release().perform();
		}
	
	public static void Apidemo()
	{
		WebElement Api = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"API Demos\"]"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(Api))).perform();
		
		WebElement Apidem = driver.findElement(By.xpath("//android.widget.TextView[@text= 'API Demos']"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(Apidem))).perform();
		
		WebElement listem = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator
				("new UiScrollable(new UiSelector())"
				+ ".scrollIntoView(" + "new UiSelector().text(\"Views\"))"));
		listem.click();
				
		/*WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@text= 'Views']"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();*/
		
		WebElement controls = driver.findElement(By.xpath("//android.widget.TextView[@text= 'Controls']"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(controls))).perform();
		
		WebElement custometheme = driver.findElement(By.xpath("//android.widget.TextView[@text= '07. Custom Theme']"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(custometheme))).perform();
		
		WebElement textbox = driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit"));
		textbox.sendKeys("koteswaraRao");
		
		
		WebElement radiobutton = driver.findElement(By.xpath("//android.widget.RadioButton[@index = '0']"));
		System.out.println(radiobutton.isDisplayed());
		if(!radiobutton.isSelected())
		{
			radiobutton.click();
			System.out.println("The radio Button selected on the web page");
		}
		else
		{
			System.out.println("The radio Button already  selected on the web page");	
		}
				
		WebElement checkhbox = driver.findElement(By.xpath("//android.widget.CheckBox[@index = '3']"));
		System.out.println(checkhbox.isDisplayed());
		if(!checkhbox.isSelected())
		{
			checkhbox.click();
			System.out.println("The checkbox  selected on the web page");
		}
		else
		{
			System.out.println("The checkbox already  selected on the web page");	
		}
		
	}
	
	public static void teardown()
	{
		driver.quit();
	}
	
	public static void main(String[] args) throws MalformedURLException {
		
		RadioButton1.Launchpad();
		RadioButton1.screen1();
		RadioButton1.Apidemo();
		RadioButton1.teardown();
		
	}

}
