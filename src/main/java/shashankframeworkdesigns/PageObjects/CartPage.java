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

public class CartPage extends AbstractComp{
	
	WebDriver driver;
	
	
	
	public CartPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbutton;
	
	public Boolean listofcart(String productname) {
		Boolean match =cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().
				 equalsIgnoreCase(productname));
		return match ;
	}
	
	public Paymentpage checkout() {
		checkoutbutton.click();
		Paymentpage paymentpage = new Paymentpage(driver);
		return paymentpage;
		
	}
			  
	
	
	}
