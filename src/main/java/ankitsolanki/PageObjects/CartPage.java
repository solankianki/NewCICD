package ankitsolanki.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ankitsolanki.AbstractComponents.AbstractComponent;


public class CartPage extends AbstractComponent {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//List <WebElement> selectedItems= driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css=".cartSection h3")
	List<WebElement> selectedItems;
	
	@FindBy(css=".subtotal button")
	WebElement CheckoutButton;
	
	public List<WebElement> selectedProducts()
	{
		return selectedItems;
	}
	public Boolean VerifyItem(String productName)
	{
		Boolean itemName=selectedProducts().stream().anyMatch(selectedItem->selectedItem.getText().equals(productName));
		return itemName;
	}
	public CheckoutPage Checkout()
	{
		CheckoutButton.click();
		return new CheckoutPage(driver);
	}

}
