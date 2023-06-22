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

public class Youautamated {
	public static DesiredCapabilities cap;
	public static AndroidTouchAction tap;
	public static AndroidDriver driver;
	public static void Launchyoutube() throws MalformedURLException
	{
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy J3 (2016)");
		cap.setCapability("appPackage", "com.sec.android.app.launcher");
		cap.setCapability("appActivity", "com.android.launcher2.Launcher");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement APPS = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Apps\"]"));
		 tap = new AndroidTouchAction(driver);
		tap.tap(TapOptions.tapOptions().withElement(ElementOption.element(APPS))).perform();
		
		}
	
	public static void launchyoutubeicons()
	{
	
		WebElement clickyoutubeicon = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"YouTube, 272 new items\"]"));
		tap.tap(TapOptions.tapOptions().withElement(ElementOption.element(clickyoutubeicon))).perform();
		
		WebElement youtubelogo = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"YouTube\"]"));
		System.out.println(youtubelogo.isDisplayed());
		
		WebElement searchbox = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]"));
		System.out.println(searchbox.isEnabled());
		WebElement searchbox1 = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]"));
		searchbox1.click();
		WebElement searchbox3 = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']"));
		searchbox3.sendKeys("Rd automachine lerning");
		
		
		
	}

	public static void main(String[] args) throws MalformedURLException {
	
		Youautamated.Launchyoutube();
		Youautamated.launchyoutubeicons();
	}

}
