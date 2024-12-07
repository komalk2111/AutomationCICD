package rahulshettyacademy.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.CheckOutPage;
import rahulshettyacademy.PageObjects.ConfirmationPage;
import rahulshettyacademy.PageObjects.LandingPage;
import rahulshettyacademy.PageObjects.OrderPage;
import rahulshettyacademy.PageObjects.ProductCatalouge;
import rahulshettyacademy.TestComponents.BaseTest;

public class SubmitOrderTest1 extends BaseTest 
{
	    String productname="ZARA COAT 3";
	    
	   @Test(dataProvider="getData",groups= {"purchase"})
		public void submitOrder(HashMap<String ,String>input ) throws IOException, InterruptedException
		{
			
			LandingPage landingPage=launchApplication();
	        ProductCatalouge ProductCatalouge=landingPage.loginApplication(input.get("email"),input.get("password"));
	        List<WebElement>products=ProductCatalouge.getProductList();
	        
	        //retrive product & Add to cart
	        ProductCatalouge.addProductToCart(input.get("product"));
	        
	        //Implementation of explicit wait to handle application synchronously on loading
	        CartPage CartPage =ProductCatalouge.goToCartPage();
	        Boolean match = CartPage.verifyProductDisplay(input.get("product"));
	        Assert.assertTrue(match);
	        
	        //checkout
	        CheckOutPage CheckOutPage= CartPage.goToCheckOut();
	        CheckOutPage.selectCountry("India");
	        ConfirmationPage  ConfirmationPage=CheckOutPage.submitOrder();
	        String ConfirmatonMsg=ConfirmationPage.getConfirmMsg();
	       
	        Assert.assertTrue(ConfirmatonMsg.equalsIgnoreCase("Thankyou for the order."));
	        
	}
	   @Test(dependsOnMethods= {"submitOrder"})
	   public void orderHistryTest() 
	   {
		   ProductCatalouge ProductCatalouge=landingPage.loginApplication("Apurva@gmail.com","Apurva1234");
		   OrderPage ordersPage= ProductCatalouge.goToOrderPage();
		   Assert.assertTrue(ordersPage.verifyOrderDisplay(productname));   
	   }
	   @Test
	   public String getScreenshot(String TestCaseName) throws IOException
	   {
		   TakesScreenshot ts=(TakesScreenshot)driver;
		   File source=ts.getScreenshotAs(OutputType.FILE);
		   File file=new File(System.getProperty("user.dir")+".//reports//" + TestCaseName +".png");
		   FileUtils.copyFile(source, file);
		   return System.getProperty("user.dir")+"//reports//" + TestCaseName +".png";
	   } 

	   @DataProvider
	   public Object [] [] getData() throws IOException
	   {
		
		   
		   List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
			return new Object[][]   {{data.get(0)},{data.get(1)}};
	   }	   
	}


     //@DataProvider
     //public Object [] [] getData()
      //{
       //return new Object[][]   {{"kumthekar@gmail.com","Kumthekar1234$","ADIDAS ORIGINAL"},{"Apurva@gmail.com","Apurva1234","ZARA COAT 3"}}

//  HashMap<String,String>map=new HashMap<String,String>();
//  map.put("email","Apurva@gmail.com");
//  map.put("password", "Apurva1234");
//  map.put("product", "ZARA COAT 3");
  
 // HashMap<String,String>map1=new HashMap<String,String>();
//  map1.put("email","kumthekar@gmail.com");
 // map1.put("password","Kumthekar1234$");
//  map1.put("product", "ADIDAS ORIGINAL");
