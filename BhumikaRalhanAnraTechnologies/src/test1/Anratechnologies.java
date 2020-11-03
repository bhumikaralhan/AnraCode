package test1;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Anratechnologies 
{

	static WebDriver driver ;
	
	
	static String AmazonSearchbox = "//input[@id ='twotabsearchtextbox']";
	static String LowcostBook = "//span[contains(text(),'LOW IODINE COOKBOOK: Nutritious Daily Recipes And Meal Plan For Healthier Life')]";
	static String AddToCartButton = "//input[@id = 'add-to-cart-button']";
	static String SuccessMessage = "//span[@id = 'post-atc-success-text']";
	static String Cart = "//*[@id=\"nav-cart\"]";
	static String ProceedToCheckout = "//input[@name = 'proceedToRetailCheckout']";
	static String UserName = "//input[@type='email']";
	static String Continue = "//input[@id='continue']";
	
	static String Password = "//input[@name = 'password']";
	static String SignInButton = "//input[@id = 'signInSubmit']";
	static String DelieverToThisAddress = "//*[@id=\"address-book-entry-0\"]/div[2]/span/a";
	static String LowiodineCookBookurl = "//Span[@Class = 'a-size-medium sc-product-title a-text-bold']";
	static String Price = "//Span[contains(text(),'$11.99')]";
	
	
	
	
	
	
	public static void main(String[] args) throws IOException , InterruptedException {
		// TODO Auto-generated method stub
			
		
		VerifyAmazonFunctionality();
		
		
	}
	public static void VerifyAmazonFunctionality() throws IOException, InterruptedException {
		//driver.navigate().to(Url);
		//driver.manage().window().maximize();
		Driversetup d = new Driversetup();
		driver = d.launch();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		System.out.println("Coming to Amazon Website");
		driver.findElement(By.xpath(AmazonSearchbox )).click();
		driver.findElement(By.xpath(AmazonSearchbox )).sendKeys("Selenium Books");
		Thread.sleep(3000);
		driver.findElement(By.xpath(AmazonSearchbox)).sendKeys(Keys.ENTER);
		
		System.out.println("Coming to Click the next button in the bottom of the page through Javascript Executor");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//clicking on the next button in the bottom
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[17]/span/div/div/ul/li[7]/a")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[17]/span/div/div/ul/li[7]/a")).click();
		Thread.sleep(5000);
		// Clicking on low cost book
		System.out.println("Coming to click the book which has lowest cost on tat page");
        driver.findElement(By.xpath(LowcostBook)).click();
        // Adding book to the cart
        System.out.println("Adding book to the cart");
        driver.findElement(By.xpath(AddToCartButton)).click();
        
        Thread.sleep(4000);
        System.out.println("Book adding to the cart successfully");
        System.out.println("Coming to click the basket ");
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement ele = driver.findElement(By.xpath(Cart));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
        
		// driver.findElement(By.xpath(Cart)).click();
        
        System.out.println("Clicking on the cart successfully");
        // driver.findElement(By.xpath(ProceedToCheckout)).click();
        // Thread.sleep(4000);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(LowiodineCookBookurl))).build().perform();
        Thread.sleep(4000);
        String urlText = driver.findElement(By.xpath(LowiodineCookBookurl)).getText();
        System.out.println(" Summary of the book is "+ urlText);
        String Price1 = driver.findElement(By.xpath(Price)).getText();
        System.out.println(" Summary of the book is "+ Price1);
        
        
        
        
        	
        	
        
       /* driver.findElement(By.xpath(ProceedToCheckout)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(UserName)).sendKeys("bhumikaralhan215@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath(Continue)).click();
        
        Thread.sleep(4000);
        driver.findElement(By.xpath(Password)).click();
        driver.findElement(By.xpath(Password)).sendKeys("Kailash333@");
        Thread.sleep(3000);
        driver.findElement(By.xpath(SignInButton)).click();
        driver.findElement(By.xpath(DelieverToThisAddress)).click();
        System.out.println("books with their price are displayed");*/
        
	}
}
