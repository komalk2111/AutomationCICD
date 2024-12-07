package rahulshettyacademy.StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.CheckOutPage;
import rahulshettyacademy.PageObjects.ConfirmationPage;
import rahulshettyacademy.PageObjects.LandingPage;
import rahulshettyacademy.PageObjects.ProductCatalouge;
import rahulshettyacademy.TestComponents.BaseTest;

public class StepDefinationImpl extends BaseTest
{
	public LandingPage landingPage;
	public ProductCatalouge ProductCatalouge;
	public ConfirmationPage  ConfirmationPage;
	
	@Given("I Landed on Ecommerce page")
	public void I_Landed_on_Ecommerce_page () throws IOException
	{
		landingPage=launchApplication();
	}
	
	 @Given ("^Logged in with username (.+) and password (.+)$")
	 public void Logged_in_with_username_and_password(String username ,String password)
	 {
		ProductCatalouge=landingPage.loginApplication(username,password);
	 }
	 
	 @When ("^I add product (.+) to cart$")
	 public void i_add_product_to_cart(String productname) throws InterruptedException
	 {
		 List<WebElement>products=ProductCatalouge.getProductList();
		 ProductCatalouge.addProductToCart(productname);
	 }
	 
	 @When ("^Checkout(.+)and submit the order$")
	 public void checkout_submit_order(String productname)
	   {
		  CartPage CartPage =ProductCatalouge.goToCartPage();
		     Boolean match = CartPage.verifyProductDisplay(productname);
		      Assert.assertTrue(match);
		       
		        
		        CheckOutPage CheckOutPage= CartPage.goToCheckOut();
		        CheckOutPage.selectCountry("India");
		        ConfirmationPage=CheckOutPage.submitOrder();
		}
	  @Then ("{string} message is displayed on ConfirmationPage")
	  public void message_displayed_on_confirmationpage(String string)
	   {
		 String ConfirmatonMsg=ConfirmationPage.getConfirmMsg();
	       
	     Assert.assertTrue(ConfirmatonMsg.equalsIgnoreCase(string));
		 
	   }
	  
	  @Then("^\"([^\"]*)\" message is displayed$")
	  public void error_message_displayed(String string1) throws Throwable
	  {
		  Assert.assertEquals(string1, landingPage.getErrormessage());
		  //driver.close();
	  }
 }
