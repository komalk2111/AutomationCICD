package rahulshettyacademy.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.Retry;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.LandingPage;
import rahulshettyacademy.PageObjects.ProductCatalouge;
import rahulshettyacademy.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest 
{
	   @Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
		public void LoginErrorValidation () throws IOException, InterruptedException
		{
			String productname="ZARA COAT 3";	
	        landingPage.loginApplication("Apurva@gmail.com", "Apurva12");
		    Assert.assertEquals("Incorrect email or password.",landingPage.getErrormessage());
	        
		}
	  @Test
		public void ProductErrorValidation() throws IOException, InterruptedException
		{
			String productname="ZARA COAT 3";
			LandingPage landingPage=launchApplication();
	        ProductCatalouge ProductCatalouge=landingPage.loginApplication("Apurva@gmail.com", "Apurva1234");
	        List<WebElement>products=ProductCatalouge.getProductList();
	        
	        //retrive product & Add to cart
	        ProductCatalouge.addProductToCart(productname);
	        
	        //Implementation of explicit wait to handle application synchronously on loading
	        CartPage CartPage =ProductCatalouge.goToCartPage();
	        Boolean match = CartPage.verifyProductDisplay("ZARA COAT 33");
	        Assert.assertFalse(match);
	        
	       
	} 
}

