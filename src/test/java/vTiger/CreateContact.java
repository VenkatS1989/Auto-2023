package vTiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact
{
	public static void main(String[] args) throws Throwable 
	{

		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		ExcelFileUtility eUtil = new ExcelFileUtility();
		String LASTNAME = eUtil.readDataFromExcel("Sheet1", 1, 2);
		
		WebDriverUtility wUtil = new WebDriverUtility();
					
		WebDriver driver=null;
		if (BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge launched successfully");
		} 
		else if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome launched successfully");
		}
		else if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox launched successfully");
		}
		else 
		{
			System.out.println("Invalid browser launched");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageToLoad(driver);

		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if(contactHeader.contains(contactHeader))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}

		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		wUtil.mouseHoverAction(driver, ele);
		Thread.sleep(1000);

		driver.findElement(By.linkText("Sign Out")).click();		
		System.out.println("SignOut successful");

		driver.close();
	}
}
