package shashankframeworkdesigns.PageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shashankframeworkdesigns.AbstractComponents.AbstractComp;

public class LandingPage extends AbstractComp {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement usermail;
	
	@FindBy(id="userPassword")
	WebElement passwordele;
	
	@FindBy(id="login")
	WebElement submitbutton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalogue login(String useremail,String password ) {
		usermail.sendKeys(useremail);
		passwordele.sendKeys(password);
		submitbutton.click();
		ProductCatalogue pdc = new ProductCatalogue(driver);
		return pdc;
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void gotourl() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
