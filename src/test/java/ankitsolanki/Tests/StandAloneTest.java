package ankitsolanki.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ankitsolanki.PageObjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage= new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("ankit.solanki@appfoster.com");
		driver.findElement(By.id("userPassword")).sendKeys("ankit123");
		driver.findElement(By.id("login")).click();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		//New comments are added
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));
		List<WebElement> items = driver.findElements(By.cssSelector(".card-body"));
		WebElement prod=items.stream().filter(item->item.findElement(By.cssSelector(".card-body b")).getText()
				.equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		//Yes we have successfully integrate the CI/CD pipeline
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		for (WebElement item : items) {
//			
//			if(item.getText().contains("ZARA COAT 3"))
//			{
//				driver.findElement(By.cssSelector(".btn.w-10.rounded")).click();
//			}
//		}
		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
		
		List <WebElement> selectedItems= driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean itemName=selectedItems.stream().anyMatch(selectedItem->selectedItem.getText().equals(productName));
		Assert.assertTrue(itemName);
		driver.findElement(By.cssSelector(".subtotal button")).click();
//		driver.findElement(By.cssSelector("input[class='input txt text-validated ng-valid ng-dirty ng-touched']")).sendKeys("ankit@aol.com");
//		driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("ind");
//		List<WebElement> country= driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
//		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "India").build().perform();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(" .ta-item:nth-of-type(2)")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)", "");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
