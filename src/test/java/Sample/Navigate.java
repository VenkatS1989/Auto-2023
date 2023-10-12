package Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate
{
	public static void main(String[] args) throws Exception
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		driver.navigate().to("https://www.flipkart.com/");
		
		driver.navigate().back();
	//	Thread.sleep(10000);
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		driver.close();		
	}
}
