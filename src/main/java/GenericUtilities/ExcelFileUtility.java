package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility
{
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws Exception, IOException
	{
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	public String readDataFromExcelSheet(String sheetName, int rowNum, int cellNum) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ActiTime.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
}
