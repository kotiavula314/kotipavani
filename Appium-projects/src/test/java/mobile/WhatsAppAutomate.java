package mobile;

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

public class WhatsAppAutomate {
	public static DesiredCapabilities cap;
	public static AndroidDriver driver;
	public static AndroidTouchAction touch;
	public static void whatsapplaunch() throws MalformedURLException
	{
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy J3(2016)");
		cap.setCapability("appPackage", "com.sec.android.app.launcher");
		cap.setCapability("appActivity", "com.android.launcher2.Launcher");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		 driver = new AndroidDriver(url,cap);
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement APPS  = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Apps\"]"));
		touch = new AndroidTouchAction(driver);
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(APPS))).perform();
	}
	public static void Swipscreenforwhatsapp()
	{
		WebElement APPGRID = driver.findElement(By.id("com.sec.android.app.launcher:id/apps_grid"));
		Dimension dimension = APPGRID.getSize();
		int Anchor = APPGRID.getSize().getHeight()/2;
		
		Double Screenenwidthstart = dimension.width*0.99;
		int Screenenwidthstart1 = Screenenwidthstart.intValue();
		
		Double screenwidthend = dimension.width*0.1;
		int screenwidthend1 = screenwidthend.intValue();
		
		new TouchAction((PerformsTouchActions)driver)
		.press(PointOption.point(Screenenwidthstart1, Anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(screenwidthend1,Anchor)).release().perform();
		
	}
	
	public static void clickwhatsoperations()
	{
		WebElement whatsappicon = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"WhatsApp\"]"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(whatsappicon))).perform();
		
		WebElement kotiwhatsapp = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.whatsapp:id/conversations_row_contact_name']"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(kotiwhatsapp))).perform();
		
		WebElement cameraphoto = driver.findElement(By.xpath("//android.widget.ImageButton[@index = '2']"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(cameraphoto))).perform();
		
		WebElement attachedphoto  = driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id ='com.whatsapp:id/icon']"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(attachedphoto))).perform();
		
		WebElement Gallery  = driver.findElement(By.id("com.whatsapp:id/thumbnail"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(Gallery))).perform();
		
		WebElement photo  = driver.findElement(By.xpath("//android.widget.ImageButton[@index='3']"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(photo))).perform();
		
		
		
		/*WebElement sendmessage = driver.findElement(By.id("com.whatsapp:id/entry"));
		sendmessage.click();
		
		WebElement sendmessage1 = driver.findElement(By.id("com.whatsapp:id/entry"));
		sendmessage1.sendKeys("Hi ra Chichugada");*/
		
		WebElement sendbutton  = driver.findElement(By.id("com.whatsapp:id/send"));
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(sendbutton))).perform();
		
		
	}
	
	public static void main(String[] args) throws MalformedURLException {
		
		WhatsAppAutomate.whatsapplaunch();
		WhatsAppAutomate.Swipscreenforwhatsapp();
		WhatsAppAutomate.clickwhatsoperations();
		
		
	}

}
