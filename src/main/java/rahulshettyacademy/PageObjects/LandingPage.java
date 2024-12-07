package rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponents;

public class LandingPage extends AbstractComponents 
{
     WebDriver driver;
     
     public LandingPage ( WebDriver driver)
     {
    	 super(driver);
    	 //Intiallization
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);
     }
     
     //WebElement users=driver.findElement(By.id("userEmail"));
     //pagefactory
     
     @FindBy(id="userEmail")
     WebElement userEmail;
     
     @FindBy(id="userPassword")
     WebElement passwordEle;
     
     @FindBy(css="input[name*='login']")
     WebElement submit;
     @FindBy(css="[class*='flyInOut']")
     WebElement errorMessage;
     
     public ProductCatalouge loginApplication(String email,String password)
     {
    	 //webElement.method
    	 userEmail.sendKeys(email);
    	 passwordEle.sendKeys(password);
    	 submit.click();
    	 ProductCatalouge ProductCatalouge=new ProductCatalouge(driver);
    	 return  ProductCatalouge;
    	 
     }
     
     public String getErrormessage()
     {
    	waitForWebElementToApper(errorMessage);
    	return errorMessage.getText();
     }
     public void goTo()
     {
    	 driver.get("https://rahulshettyacademy.com/client");
     }
     
}
