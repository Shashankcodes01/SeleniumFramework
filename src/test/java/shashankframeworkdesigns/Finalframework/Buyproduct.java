package shashankframeworkdesigns.Finalframework;

import io.github.bonigarcia.wdm.WebDriverManager;

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


public class Buyproduct {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String productname = "IPHONE 13 PRO";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("viratk18@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Virat@18,");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement>products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod =products.stream().		
		filter(product->product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-child")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement>cartproducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		
		Boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[placeholder='Select Country']")));
		
		WebElement countryInput = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", countryInput);

		//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*=ta-results]")));
		
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		
		//[class*=ta-item]:nth-child(3)
		//button[contains(@class,'ta-item')][2]
		//[class*=ta-item]:nth-child(3)
		
		driver.findElement(By.xpath("//div[@class='actions']/a")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hero-primary")));
		String confirmmesg=driver.findElement(By.className("hero-primary")).getText();
		System.out.println(confirmmesg);
		boolean confirm=confirmmesg.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		Assert.assertTrue(confirm);
		
		
	}
	
}
