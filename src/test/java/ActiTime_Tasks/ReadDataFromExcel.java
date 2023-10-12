package ActiTime_Tasks;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ActiTime.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String CUSTNAME = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String CUSTDESC = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		
		System.out.println(CUSTNAME);
		System.out.println(CUSTDESC);
	}
}
