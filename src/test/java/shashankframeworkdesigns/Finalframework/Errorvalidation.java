package shashankframeworkdesigns.Finalframework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import shashankframeworkdesigns.Basetest.BaseTest;

public class Errorvalidation extends BaseTest {
	
	@Test (groups = {"Errorvalid"})
	public void LoginErrorValidation() throws IOException, InterruptedException {

		//landpage = launchapplication(); //newly added for error
		landpage.login("anshika@gmail.com", "Iamk000");
		Assert.assertEquals("Incorrect email or password.", landpage.getErrorMessage());

	}
}
