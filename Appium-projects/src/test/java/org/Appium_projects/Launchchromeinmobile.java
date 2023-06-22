package org.Appium_projects;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Launchchromeinmobile {

	public static void main(String[] args) throws MalformedURLException {
		ChromeOptions  options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		DesiredCapabilities cap = new DesiredCapabilities(options);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"4200cde568dc3300");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability("ChromeOptions", ImmutableMap.of("w3c",false));
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		driver.get("https://www.facebook.com/");
		
		driver.close();
		
		
		
	}	
	
}
