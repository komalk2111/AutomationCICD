package rahulshettyacademy.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.CheckOutPage;
import rahulshettyacademy.PageObjects.ConfirmationPage;
import rahulshettyacademy.PageObjects.LandingPage;
import rahulshettyacademy.PageObjects.ProductCatalouge;
import rahulshettyacademy.TestComponents.BaseTest;
/*
public class SubmitOrderTest 
{
	//Code using Page Objects
    
public static void main(String[] args) throws InterruptedException
	{
		String productname="ZARA COAT 3";
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		LandingPage LandingPage=new LandingPage(driver);
        LandingPage.goTo();
        ProductCatalouge ProductCatalouge=LandingPage.loginApplication("Apurva@gmail.com", "Apurva1234");
        
       
        List<WebElement>products=ProductCatalouge.getProductList();
        
        //retrive product & Add to cart
        ProductCatalouge.addProductToCart(productname);
        
        //Implementation of explicit wait to handle application synchronously on loading
        CartPage CartPage =ProductCatalouge.goToCartPage();
        Boolean match = CartPage.verifyProductDisplay(productname);
        Assert.assertTrue(match);
        
        //checkout
        CheckOutPage CheckOutPage= CartPage.goToCheckOut();
        CheckOutPage.selectCountry("India");
        ConfirmationPage  ConfirmationPage=CheckOutPage.submitOrder();
        String ConfirmatonMsg=ConfirmationPage.getConfirmMsg();
       
        Assert.assertTrue(ConfirmatonMsg.equalsIgnoreCase("Thankyou for the order."));
        
}
}
	*/