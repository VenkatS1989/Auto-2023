package GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility
{
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String value = pobj.getProperty(key);
		return value;
	}
	
	public String readDataFromProperty(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonDataActiTime.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String value = pobj.getProperty(key);
		return value;
		
	}
}
