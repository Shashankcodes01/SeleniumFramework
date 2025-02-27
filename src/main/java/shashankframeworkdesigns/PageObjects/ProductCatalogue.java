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

public class ProductCatalogue extends AbstractComp{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement animation;
	
	By productsby = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-child");
	By toastmessage = By.id("toast-container");
	public List<WebElement> productlist() {
		waitforproducttoappear(productsby);
		return products;
	}
	
	public WebElement getproductbyname(String productname) {
		WebElement prod =productlist().stream().		
				filter(product->product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
		return prod;
	}
	
	public Addtocart addproducttocart(String productname) {
		WebElement prod=getproductbyname(productname);
		prod.findElement(addtocart).click();
		waitforproducttoappear(toastmessage);
		waituntilitdisappears(animation);
		Addtocart addc = new Addtocart(driver);
		return addc;
		
	}
}
