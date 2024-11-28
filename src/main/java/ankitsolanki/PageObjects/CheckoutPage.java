package ankitsolanki.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ankitsolanki.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(css=" .ta-item:nth-of-type(2)")
	WebElement SubmitCountry;
	@FindBy(css=".action__submit")
	WebElement submit;
	By results = By.cssSelector(".ta-results");
	
	public void SelectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(Country, countryName).build().perform();
		WaitfortheElementToAppear(results);
		SubmitCountry.click();
		
	}
	public ConfirmationPage SubmitOrder() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)", "");
		Thread.sleep(2000);
		submit.click();
		return new ConfirmationPage(driver);
	}

}
