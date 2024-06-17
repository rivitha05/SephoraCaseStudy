package AppiumFramework.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AppiumUserFlow {
	
	AndroidDriver driver;
	
	public AppiumUserFlow(AndroidDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="ae.sephora.sephorauae:id/button_connection")
	WebElement loginButton;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\\\"ae.sephora.sephorauae:id/et_mail\\")
	WebElement emailId;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\\\"ae.sephora.sephorauae:id/et_password\\")
	WebElement password;
	
	@AndroidFindBy(id="ae.sephora.sephorauae:id/btn_main_button")
	WebElement signInButton;
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void enterEmail(String mail)
	{
		emailId.sendKeys(mail);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickSignIn()
	{
		signInButton.click();
	}
	
}
