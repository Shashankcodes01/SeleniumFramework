package shashankframeworkdesigns.Basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import shashankframeworkdesigns.PageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landpage;
	public WebDriver Driverinitializer() throws IOException {
		Properties pro = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\shashankframeworkdesigns\\resources\\GlobalData.properties");
		pro.load(fs);
		String browsername=pro.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")){
			//firefox
		}
		else if(browsername.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchapplication() throws IOException {

		 
	    driver = Driverinitializer();
	        
		 landpage = new LandingPage(driver);
		landpage.gotourl();
		
		return landpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		driver.close();
	}
}
