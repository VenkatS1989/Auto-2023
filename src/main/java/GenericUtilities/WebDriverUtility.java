package GenericUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility
{
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void mouseHoverAction(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
}
