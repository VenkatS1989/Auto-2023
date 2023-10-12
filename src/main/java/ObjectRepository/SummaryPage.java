package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage
{
	@FindBy(id = "container_tasks")
	private WebElement tasksMenu;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOutBtn;
	
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath = "//div[text()='+ New Customer']")
	private WebElement newCustomerBtn;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement customerNameEdt;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement customerDescEdt;
	
	@FindBy(xpath = "//div[text()='Create Customer']")
	private  WebElement createCustomerBtn;
		
	public SummaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTasksMenu() 
	{
		return tasksMenu;
	}

	public WebElement getLogOutBtn() 
	{
		return logOutBtn;
	}

	public WebElement getAddNewBtn()
	{
		return addNewBtn;
	}

	public WebElement getNewCustomerBtn()
	{
		return newCustomerBtn;
	}

	
	public WebElement getCustomerNameEdt() {
		return customerNameEdt;
	}

	public WebElement getCustomerDescEdt() {
		return customerDescEdt;
	}

	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}

	public void clickOnTasksMenu()
	{
		tasksMenu.click();
	}
	
	public void clickOnlogOut()
	{
		logOutBtn.click();
	}
	
	public void clickOnAddNew()
	{
		addNewBtn.click();
	}
	
	public void clickOnNewCustomer()
	{
		newCustomerBtn.click();
	}
	public void createNewCustomer(String CUSTNAME, String CUSTDESC)
	{
		customerNameEdt.sendKeys(CUSTNAME);
		customerDescEdt.sendKeys(CUSTDESC);
		createCustomerBtn.click();
	}
}
