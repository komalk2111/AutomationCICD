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

import rahulshettyacademy.PageObjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) 
	{
		//String productname="ZARA COAT 3";
		//WebDriverManager.ChromeDriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
        LandingPage LandingPage=new LandingPage(driver);
        driver.findElement(By.id("userEmail")).sendKeys("Apurva@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Apurva1234");
        driver.findElement(By.cssSelector("input[name*='login']")).click();
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        //retrive product & Add to cart
        List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        
        //Implementation of explicit wait to handle application synchronously on loading
    
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        
        //logic to verify items in cart with streams 
        List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match =cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase("ZARA COAT 3"));
        Assert.assertTrue(match);
       //checkout
        driver.findElement(By.cssSelector(".totalRow button")).click();
        
       //select coutry
        Actions a=new Actions(driver); 
        a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();
        String confirmMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue( confirmMsg.equalsIgnoreCase("Thankyou for the order."));
        
}
}