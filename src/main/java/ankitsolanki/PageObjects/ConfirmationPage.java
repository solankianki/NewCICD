package ankitsolanki.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ankitsolanki.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".hero-primary")
	WebElement Confirmmessage;
	
	public String ConfirmationMessage()
	{
		String msg=Confirmmessage.getText();
		return msg;
	}

}
