package ActiTime_Tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.ActiLoginPage;
import ObjectRepository.CustomerHeaderPage;
import ObjectRepository.SummaryPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCustomer
{
	public static void main(String[] args) throws InterruptedException, Throwable
	{
		ExcelFileUtility eutil = new ExcelFileUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		WebDriverUtility wutil =new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		
		String BROWSER = putil.readDataFromProperty("browser");
		String URL = putil.readDataFromProperty("url");
		String USERNAME = putil.readDataFromProperty("username");
		String PASSWORD = putil.readDataFromProperty("password");
		
		String CUSTNAME = eutil.readDataFromExcelSheet("Sheet1", 1, 2) + jutil.getRandomNumber();
		String CUSTDESC = eutil.readDataFromExcelSheet("Sheet1", 1, 3);
		
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
		
		wutil.maximizeWindow(driver);
		wutil.waitForPageToLoad(driver);
		
		driver.get(URL);
		
		ActiLoginPage alp = new ActiLoginPage(driver);
		alp.loginToApp(USERNAME, PASSWORD);
		
		SummaryPage sp = new SummaryPage(driver);
		sp.clickOnTasksMenu();
		sp.clickOnAddNew();
		sp.clickOnNewCustomer();
		sp.createNewCustomer(CUSTNAME, CUSTDESC);
		
		CustomerHeaderPage chp = new CustomerHeaderPage(driver);
		
		String custHeader = chp.customerHeaderText();
		
		if (custHeader.contains(custHeader)) 
		{
			System.out.println("PASS");
		} 
		else
		{
			System.out.println("FAIL");
		}
		
		sp.clickOnlogOut();
		System.out.println("Application SignOut");
		driver.close();
	}
}
