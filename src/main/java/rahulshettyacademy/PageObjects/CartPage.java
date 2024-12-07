package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponents;

public class CartPage extends AbstractComponents
{
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutvalue;

	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyProductDisplay(String productname)
	{
		Boolean match =cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
		
		return match;
	}
	
	public CheckOutPage goToCheckOut()
	{
		checkoutvalue.click();
		return new CheckOutPage(driver);
		
	}
      
}
