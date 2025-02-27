package shashankframeworkdesigns.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import shashankframeworkdesigns.AbstractComponents.AbstractComp;

public class Confirmationpage extends AbstractComp{
	
	WebDriver driver;
	
	public Confirmationpage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className="hero-primary")
	WebElement message;
	
	By confirmmessage = By.className("hero-primary");
	
	public boolean confirmnow() {
		waitforproducttoappear(confirmmessage);
		String cnmf=message.getText();
		boolean confirmnow=cnmf.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		return confirmnow;
		
	}
	
	
	
}
