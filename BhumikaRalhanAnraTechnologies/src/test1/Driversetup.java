package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class Driversetup {
		public WebDriver driver;
		static String Location = "C:\\Users\\BhumikaRalhan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		static String Url = "http://www.amazon.com";
		
		public WebDriver launch() {
		
		System.setProperty("webdriver.chrome.driver", Location);
	    WebDriver driver = new ChromeDriver();
	    driver.navigate().to(Url);
		driver.manage().window().maximize();
		return driver;
		
	}
	}


