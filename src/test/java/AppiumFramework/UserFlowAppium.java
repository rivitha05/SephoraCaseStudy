package AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AppiumFramework.pageobjects.AppiumUserFlow;
import io.appium.java_client.android.AndroidDriver;

@Test
public class UserFlowAppium extends MyBaseTest {
	

	public void userflowappium(HashMap<String,String> input) throws MalformedURLException, URISyntaxException, InterruptedException
	{   AppiumUserFlow userflow = new AppiumUserFlow((AndroidDriver)driver);
		userflow.clickLogin();
		userflow.enterEmail(input.get("email"));
		userflow.enterPassword(input.get("password"));
		userflow.clickSignIn();
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsondata(System.getProperty("user.dir")+"//src//test//java//SeleniumFramework//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};


	}
}
