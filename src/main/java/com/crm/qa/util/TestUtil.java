package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
public static long PAGE_LOAD_TIMEOUT=70;
public static long IMPLICT_WAIT=60;


public static String TEST_DATA_SHEET_PATH="D:\\Selenium\\Selenium Prog1\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx";
static Workbook book;
static org.apache.poi.ss.usermodel.Sheet sheet;

public static Object[][] getTestData(String sheetName)
{
	FileInputStream file=null;
	
	try
	{
		file=new FileInputStream(TEST_DATA_SHEET_PATH);
		
		
		//File src=new File(excelPath);
		 
		book=new XSSFWorkbook(file);
		
	}catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
		catch(IOException e)
	{
			e.printStackTrace();
	}
	sheet=book.getSheet(sheetName);
	Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
		{
		data[i][k]=sheet.getRow(i+1).getCell(k).toString();	
		}
	

	
}
	return data;
}


}
