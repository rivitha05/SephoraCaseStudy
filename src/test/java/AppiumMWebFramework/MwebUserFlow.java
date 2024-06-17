package AppiumMWebFramework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@Test
public class MwebUserFlow {
	
	  public static void main(String[] args) throws MalformedURLException, InterruptedException, URISyntaxException {
		  
		  AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
					service.start();
		  UiAutomator2Options options = new UiAutomator2Options(); 
		  options.setDeviceName("RivithaEmulatorPixel3a");
			 options.setCapability("browserName", "Chrome");
		     options.setCapability("autoGrantPermissions", true);
		     AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
	        driver.get("https://sephora.ae");
	        driver.quit();
			service.stop();
	    }
	
	
   
}
