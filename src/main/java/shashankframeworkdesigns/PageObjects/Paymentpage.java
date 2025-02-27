package shashankframeworkdesigns.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import shashankframeworkdesigns.AbstractComponents.AbstractComp;

public class Paymentpage extends AbstractComp{
	
	WebDriver driver;
	
	
	
	public Paymentpage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement countryselection;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement choosecountry;
	
	@FindBy(xpath="//div[@class='actions']/a")
	WebElement placeord;
	
	By countrydropdown = By.cssSelector("[class*=ta-results]");
	
	
	
	public void selectcountry(String countryname) {
		elementclickable(countryselection);
		
		WebElement countryInput = countryselection;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", countryInput);
		
		countryselection.sendKeys(countryname);
		
		waitforproducttoappear(countrydropdown);
		
		choosecountry.click();
	}
	
	public Confirmationpage placeorder() {
		placeord.click();
		Confirmationpage cnmf = new Confirmationpage(driver);
		return cnmf;
	}
	
	
	
}	
