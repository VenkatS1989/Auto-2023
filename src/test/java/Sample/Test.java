package Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test
{
	public static void main(String[] args) throws Exception
	{
	/*	
	    WebDriverManager.firefoxdriver().setup();
		WebDriverManager.safaridriver().setup();
	    WebDriverManager.chromedriver().setup();
	*/
	//	System.setProperty("webdriver.edge.driver", "C://EdgeDriver.exe");
	//	WebDriverManager.edgedriver().setup();
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch the browser
		driver.manage().window().maximize(); // maximize the browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.manage().window().minimize();
		
		driver.get("https://www.amazon.in/");
		
//		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		driver.close();
	//	driver.quit();
		
	}
}
