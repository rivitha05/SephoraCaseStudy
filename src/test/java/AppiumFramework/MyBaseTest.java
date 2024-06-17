package AppiumFramework;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import AppiumFramework.pageobjects.AppiumUserFlow;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
public class MyBaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	


@BeforeClass
public void ConfigureAppium() throws MalformedURLException, URISyntaxException
{
	service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
	.withIPAddress("127.0.0.1").usingPort(4723).build();
	service.start();
	 
	UiAutomator2Options options = new UiAutomator2Options();
	 options.setDeviceName("RivithaEmulatorPixel3a");
     options.setApp("/Users/crazyrivitha/eclipse-workspace/SephoraCaseStudy/src/test/java/resources/Sephora UAE_ Beauty, Makeup_3.11.80_APKPure.apk");
     options.setCapability("appPackage", "ae.sephora.sephorauae");
     options.setCapability("appActivity", "fr.sephora.aoc2.ui.launcher.LauncherBaseActivity");
     options.setCapability("autoGrantPermissions", true);
	driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
}

@AfterClass
public void tearDown()
{
	driver.quit();
	service.stop();
}

public List<HashMap<String, String>> getJsondata(String filePath) throws IOException
{
	
	String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
});
	return data;
}

public String getScreenshot(String testCaseName,AppiumDriver driver) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png";
	
}
}

