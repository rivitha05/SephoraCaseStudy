package SeleniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponent;


	public class SeleniumUserFlow extends AbstractComponent {	
	WebDriver driver;
	
	public SeleniumUserFlow(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dwfrm_crmsephoracard_email")
	WebElement userEmail;
	
	@FindBy(linkText="Log in")
	WebElement logIn;
	
	@FindBy(css=".grid-tile")
	List<WebElement> products;
	
	@FindBy(id="add-to-cart")
	WebElement addCart;
	
	@FindBy(id="addtocartpopin-gotodelivery-payment")
	WebElement proceedPaymentButton;
	
	@FindBy(xpath="//div[@class='language-search-wrapper']//input[@placeholder='Search a product, a brand...']")
	WebElement searchBarElement;
	
	@FindBy(css="button[value='Apply']")
	WebElement formBoxElement;
	
	By loginFormBox = By.cssSelector(".login-form-box");
	By dialogBox = By.id("dialog-container");
	
	public void clickLogin()
	{
		logIn.click();
	}
	
	public void enterCredentials(String email)
	{
		userEmail.sendKeys(email);
	}
	
	public void goTo()
	{
		driver.get("https://www.sephora.ae/en/new/view-all-view-all-newness/?gad_source=1&gclid=EAIaIQobChMI4N7-14DehgMV6wcGAB1PBgLGEAAYASAAEgJDBPD_BwE&gclsrc=aw.ds");
	}
	
	public void waitForFormBoxToLoad()
	{
		waitForElementToAppear(loginFormBox);
	}
	
	public void waitForDialogBoxToLoad()
	{
		waitForElementToAppear(dialogBox);
	}
	
	public List<WebElement> getProductList()
	{
		return products;
	}
	
	public void addToCart()
	{
		addCart.click();
	}
	
	public void proceedPayment()
	{
		proceedPaymentButton.click();
	}
	
	public void searchBarClick()
	{
		searchBarElement.click();
	}
	
	public void searchBar(String searchItem)
	{
		searchBarElement.sendKeys(searchItem);
	}
	
	public void searchBarEnter()
	{
		searchBarElement.sendKeys(Keys.ENTER);
	}
	
	public void formBox()
	{
		formBoxElement.click();
	}
	
	public WebElement getProductByName(String productname)
	{
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("h3")).getText().equals(productname))
				.findFirst()
				.orElse(null);
		return prod;
	}
	
	public void AddProduct(String productname)
	{
		WebElement prod = getProductByName(productname);
		prod.click();
	}
}
