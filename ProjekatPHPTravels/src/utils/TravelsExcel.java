package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TravelsExcel {

	private XSSFSheet sheet;
	private XSSFWorkbook wb;

	public void readExcel() throws IOException
	{
		File file = new File("Username.xlsx");
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		
//		String[] userpass = new String[2];
//		userpass[0] = sheet.getRow(1).getCell(0).getStringCellValue();
//		userpass[1] = sheet.getRow(1).getCell(1).getStringCellValue();
//		return userpass;
		
	}
	
	public String getUsername()
	{
		return sheet.getRow(1).getCell(0).getStringCellValue();
	}
	
	public String getPassword()
	{
		return sheet.getRow(1).getCell(1).getStringCellValue();
	}
		
	public void workbookClose() throws IOException
	{
		wb.close();
	}

}
