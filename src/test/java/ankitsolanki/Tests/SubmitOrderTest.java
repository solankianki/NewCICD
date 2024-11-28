package ankitsolanki.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ankitsolanki.PageObjects.CartPage;
import ankitsolanki.PageObjects.CheckoutPage;
import ankitsolanki.PageObjects.ConfirmationPage;
import ankitsolanki.PageObjects.OrderPage;
import ankitsolanki.PageObjects.ProductCatalogue;
import ankitsolanki.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName="ZARA COAT 3";
	@Test(dataProvider="getData",groups="Sanity")
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException	
	{
		// TODO Auto-generated method stub
		
		ProductCatalogue productCatalogue =landingPage.loginApplication(input.get("email"),input.get("password"));
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartpage = productCatalogue.goToCart();
		
		Boolean match=cartpage.VerifyItem(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.Checkout();
		checkoutpage.SelectCountry("India");
		ConfirmationPage confirmationPage=checkoutpage.SubmitOrder();
		String message=confirmationPage.ConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	@Test(dependsOnMethods = {"SubmitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue =landingPage.loginApplication("ankit.solanki@appfoster.com","ankit123");
		OrderPage orderPage=productCatalogue.goToOrder();
		Assert.assertTrue(orderPage.VerifyOrder(productName));	
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data=getJasonDatatoMap(System.getProperty("user.dir")+"//src//test//java//ankitsolanki//Data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
