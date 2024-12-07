package rahulshettyacademy.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.OrderPage;

public class AbstractComponents
{
	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
         this.driver=driver;
         PageFactory.initElements(driver, this);
	}
     @FindBy(css="[routerlink*='cart']")
     WebElement cartHeader;
     
     @FindBy(css="[routerlink*='myorders']")
     WebElement orderHeader;
	
	public void waitForElementToApper(By findBy)
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementToApper(WebElement findBy)
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage CartPage=new CartPage(driver);
		return CartPage;
	}
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage OrderPage=new OrderPage(driver);
		return OrderPage;
	}
	
	
	public void waitForElementTpDisapper(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
