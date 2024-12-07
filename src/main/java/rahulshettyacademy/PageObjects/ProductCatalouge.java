package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponents;

public class ProductCatalouge extends AbstractComponents 
{
     WebDriver driver;
     
     public ProductCatalouge ( WebDriver driver)
     {
    	 //Intiallization
    	 super(driver);
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);
     }
     
     @FindBy(css=".mb-3")
     List<WebElement> products;
     
     @FindBy(css=".ng-animating")
     WebElement spinner;
      
     //trying
     //@FindBy(css=(".cartSection h3"))
     //List<WebElement> cartproducts;
     //
     By productBy=By.cssSelector(".mb-3");
     By addToCart=By.cssSelector(".card-body button:last-of-type");
     By toastMsg=By.cssSelector("#toast-container");
     
     public List<WebElement> getProductList()
     {
    	 waitForElementToApper(productBy);
    	 return products;
     }
     
     public WebElement getProductByName(String productname)
     {
    	WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
    	 
     }
     
     public void addProductToCart(String productname) throws InterruptedException
     {
    	WebElement prod=getProductByName(productname);
    	prod.findElement(addToCart).click();
    	waitForElementToApper(toastMsg);
    	waitForElementTpDisapper(spinner);
     }
     
   
     
}
