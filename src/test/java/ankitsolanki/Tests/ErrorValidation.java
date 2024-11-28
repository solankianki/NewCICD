package ankitsolanki.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ankitsolanki.PageObjects.CartPage;
import ankitsolanki.PageObjects.ProductCatalogue;
import ankitsolanki.TestComponents.BaseTest;
import ankitsolanki.TestComponents.Retry;

public class ErrorValidation extends BaseTest {

	
	@Test(groups ={"Smoke"},retryAnalyzer = Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException	
	{
		// TODO Auto-generated method stub
		
		ProductCatalogue productCatalogue =landingPage.loginApplication("ankit.solanki@appfoster.com","ankit13");
		
		Assert.assertEquals("Incorrect email or password.", landingPage.ErrorMessage());
	}
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException	
	{
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		ProductCatalogue productCatalogue =landingPage.loginApplication("solankiankit66@gmail.com", "Rahul@123");
		productCatalogue.addProductToCart(productName);
		CartPage cartpage = productCatalogue.goToCart();
		Boolean match=cartpage.VerifyItem("ZARA COAT 33");
		Assert.assertFalse(match);

	}

}
