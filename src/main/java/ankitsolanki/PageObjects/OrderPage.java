package ankitsolanki.PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ankitsolanki.AbstractComponents.AbstractComponent;



public class OrderPage extends AbstractComponent {
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//
	@FindBy(css=".ng-star-inserted td:nth-child(3)")
	private List<WebElement> orderedItems;
	
	public List<WebElement> orderedProducts()
	{
		return orderedItems;
	}
	public Boolean VerifyOrder(String productName)
	{
		Boolean itemName=orderedProducts().stream().anyMatch(selectedItem->selectedItem.getText().equalsIgnoreCase(productName));
		return itemName;
	}


}
