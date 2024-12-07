package rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponent.AbstractComponents;

public class CheckOutPage extends AbstractComponents
{
	WebDriver driver;

	public CheckOutPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	@FindBy(css="input[placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selecCountry;
    
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By result=By.cssSelector(".ta-results");
	  
	
	public void selectCountry(String CountryName)
	{
		    Actions a=new Actions(driver); 
	        a.sendKeys(Country, CountryName).build().perform();
	        waitForElementToApper(result);
	        selecCountry.click();
	        
	}
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
	    return new ConfirmationPage(driver);
	}

}
