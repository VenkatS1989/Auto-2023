package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerHeaderPage
{
	@FindBy(className = "titleEditButtonContainer")
	private WebElement custHeaderText;
	
	public CustomerHeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustHeaderText() {
		return custHeaderText;
	}

public String customerHeaderText()
{
	return custHeaderText.getText();
}
	
}
