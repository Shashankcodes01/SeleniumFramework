package shashankframeworkdesigns.Finalframework;

import shashankframeworkdesigns.Basetest.BaseTest;
import shashankframeworkdesigns.PageObjects.Addtocart;
import shashankframeworkdesigns.PageObjects.CartPage;
import shashankframeworkdesigns.PageObjects.Confirmationpage;

import shashankframeworkdesigns.PageObjects.Paymentpage;
import shashankframeworkdesigns.PageObjects.ProductCatalogue;
import shashankframeworkdesigns.data.Datareader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EndtoEndJourney extends BaseTest {
	String productname = "ADIDAS ORIGINAL";
	@Test(dataProvider="getData",groups= {"Purchase"})

	public void submitorder(HashMap<String,String> input) throws IOException {
		
		String coutryname = "India";

		ProductCatalogue pdc = landpage.login(input.get("email"), input.get("password"));

		Addtocart addc = pdc.addproducttocart(input.get("productname"));

		CartPage cartpage = addc.clickoncartbutton();

		Boolean match = cartpage.listofcart(input.get("productname"));

		Assert.assertTrue(match);

		Paymentpage paymentpage = cartpage.checkout();

		paymentpage.selectcountry(coutryname);

		Confirmationpage cnmf = paymentpage.placeorder();

		Boolean confirm = cnmf.confirmnow();

		Assert.assertTrue(confirm);

	}
	@Test(dependsOnMethods= {"submitorder"})
	public void Orderconfirmpage() {
		ProductCatalogue pdc = landpage.login("viratk18@gmail.com", "Virat@18,");
		Addtocart adc = new Addtocart(driver);
		adc.clickonOrdersbutton();
		Assert.assertTrue(adc.Verifyyouorder(productname));
		
	}
	
	@Test(groups= {"Errorvalid"})
	public void login() {
		ProductCatalogue pdc = landpage.login("viratk18@gmail.com", "Virat@18,");
	}
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		Datareader dr = new Datareader();
		List<HashMap<String,String>> data = dr.dataconverter(System.getProperty("user.dir")+"\\src\\test\\java\\shashankframeworkdesigns\\data\\Data.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
	}

}
