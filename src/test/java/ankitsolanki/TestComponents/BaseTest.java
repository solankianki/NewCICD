package ankitsolanki.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ankitsolanki.Data.DataReader;
import ankitsolanki.PageObjects.LandingPage;

public class BaseTest extends DataReader {
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//ankitsolanki//resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
//		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions Options= new ChromeOptions();
			if(browserName.contains("headless"))
			{
				Options.addArguments("headless");
			}
			driver = new ChromeDriver(Options);
			driver.manage().window().setSize(new Dimension(1440,900));
		
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		landingPage= new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	public String getscreenShot(String screenshotName,WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"//reports//"+screenshotName+".png") );
		return System.getProperty("user.dir")+"//reports//"+screenshotName+".png";
	}
	@AfterMethod(alwaysRun = true)
	public void exit()
	{
		if(driver!=null)
		{
		//driver.close();
		driver.quit();
		}
	}
}
