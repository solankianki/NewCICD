package ankitsolanki.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ankitsolanki.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css=".card-body")
	List<WebElement> items;
	
	@FindBy(css=".ng-animating")
	WebElement animation;
	
	By productsBy = By.cssSelector(".card-body");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		WaitfortheElementToAppear(productsBy);
		return items;
	}
	
	public WebElement getProductByName(String productName) throws InterruptedException
	{
		
		WebElement prod=items.stream().filter(item->item.findElement(By.cssSelector(".card-body b")).getText()
				.equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		WaitfortheElementToAppear(toastMsg);
		WaitforElementToDisappear(animation);
	}
	
	
	

}
