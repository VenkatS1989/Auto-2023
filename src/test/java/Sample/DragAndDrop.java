package Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop
{
	public static void main(String[] args)
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver(); //launch the browser
		driver.manage().window().maximize(); // maximize the browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/");
		
		WebElement ele1 = driver.findElement(By.xpath("//h1[text()='Block 1']"));
		WebElement ele2 = driver.findElement(By.xpath("//h1[text()='Block 4']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(ele1, ele2).perform();
		
		driver.close();
	}
}
