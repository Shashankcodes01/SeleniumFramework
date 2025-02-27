package shashankframeworkdesigns.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComp {

	WebDriver driver;
	public AbstractComp(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	public void waitforproducttoappear(By findby) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));

		w.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	public void waituntilitdisappears(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void elementclickable(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		 w.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
