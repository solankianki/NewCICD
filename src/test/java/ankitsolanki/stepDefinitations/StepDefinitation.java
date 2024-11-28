package ankitsolanki.stepDefinitations;

import java.io.IOException;

import org.testng.Assert;

import ankitsolanki.PageObjects.CartPage;
import ankitsolanki.PageObjects.CheckoutPage;
import ankitsolanki.PageObjects.ConfirmationPage;
import ankitsolanki.PageObjects.LandingPage;
import ankitsolanki.PageObjects.ProductCatalogue;
import ankitsolanki.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitation extends BaseTest {
	public LandingPage landingPage;
	public CartPage cartpage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException 
	{
		landingPage=launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username,String password)
	{
		productCatalogue =landingPage.loginApplication(username,password);
	}
	
	@When("^I add product (.+) to the cart$")
	public void I_add_product_to_the_cart(String productName) throws InterruptedException
	{
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^Checkout (.+) and submit the Order$")
	public void Checkout_and_submit_the_Order(String productName) throws InterruptedException
	{
		cartpage = productCatalogue.goToCart();
		Boolean match=cartpage.VerifyItem(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.Checkout();
		checkoutpage.SelectCountry("India");
		confirmationPage=checkoutpage.SubmitOrder();
	}
	
	@Then("{string} is displayed on confirmationPage")
	public void message_is_displayed_on_confirmationPage(String string)
	{
		String message=confirmationPage.ConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string)
	{
		Assert.assertEquals(string, landingPage.ErrorMessage());
		driver.close();
	}
}
