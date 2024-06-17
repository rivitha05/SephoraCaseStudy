package SeleniumFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import SeleniumFramework.TestComponents.BaseTest;
import SeleniumFramework.pageobjects.SeleniumUserFlow;


public class UserFlow extends BaseTest {

@Test(dataProvider="getData")
public void userFlow(HashMap<String,String> input) throws IOException {
	

SeleniumUserFlow userflow = launchApplication();

userflow.clickLogin();
userflow.enterCredentials(input.get("email"));
userflow.waitForFormBoxToLoad();
System.out.println("Button clicked successfully.");
userflow.searchBarClick();
userflow.searchBar(input.get("search"));
userflow.searchBarEnter();
userflow.getProductList();
userflow.AddProduct(input.get("product"));
userflow.addToCart();
userflow.waitForDialogBoxToLoad();
}

@DataProvider
public Object[][] getData() throws IOException
{
	List<HashMap<String, String>> data = getJsondata(System.getProperty("user.dir")+"//src//test//java//SeleniumFramework//data//PurchaseOrder.json");
	return new Object[][] {{data.get(0)}, {data.get(1)}};


}
}
