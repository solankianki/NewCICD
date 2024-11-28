package ankitsolanki.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ankitsolanki.PageObjects.CartPage;
import ankitsolanki.PageObjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
	
	@FindBy(css="[routerlink='/dashboard/cart']")
	WebElement goToCart;
	
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement goToOrder;
	
	public CartPage goToCart()
	{
		goToCart.click();
		return new CartPage(driver);
	}
	public OrderPage goToOrder()
	{
		goToOrder.click();
		return new OrderPage(driver);
	}

	public void WaitfortheElementToAppear(By findBy)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void WaitfortheWebElementToAppear(WebElement ele)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	public void WaitforElementToDisappear(WebElement animation) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
//		w.until(ExpectedConditions.invisibilityOf(animation));
	}
}
