package ActiTime_Tasks;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile 
{
	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonDataActiTime.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
	}
}
