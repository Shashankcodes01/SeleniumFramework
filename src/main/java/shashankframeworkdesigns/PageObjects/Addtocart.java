package shashankframeworkdesigns.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shashankframeworkdesigns.AbstractComponents.AbstractComp;

public class Addtocart extends AbstractComp {
WebDriver driver;
	
	public Addtocart(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartbutton;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement Ordersbutton;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> Orderslist;
	
	public CartPage clickoncartbutton() {
		elementclickable(cartbutton);
		cartbutton.click();
		
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public void clickonOrdersbutton() {
		elementclickable(Ordersbutton);
		Ordersbutton.click();
	}
	
	public Boolean Verifyyouorder(String productname) {
		Boolean match =Orderslist.stream().anyMatch(orderlist->orderlist.getText().
				 equalsIgnoreCase(productname));
		return match ;
	}
}

