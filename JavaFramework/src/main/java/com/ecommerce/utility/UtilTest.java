package com.ecommerce.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilTest {

	static XSSFWorkbook wb;
	static XSSFSheet ws;
	static XSSFRow row;
	static XSSFCell col;
	static Workbook book;
	static Sheet sheet;
	
	public static String filePath= "../JavaFramework/src/main/java/com/ecommerce/testdata/UserRegistration.xlsx";
	
	public static long implicit_wait = 5;
	public static long pageLoadTime = 10;
	
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException {
		

		FileInputStream f = new FileInputStream(filePath);
		
		try {
			wb = new XSSFWorkbook(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = wb.getSheet(sheetName);
		
//		book = WorkbookFactory.create(f);
//		sheet = book.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println(rowCount+" "+colCount);
		
		Object[][] obj = new Object[rowCount][colCount];
//		DataFormatter form = new DataFormatter();
		
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
//				form.formatCellValue(sheet.getRow(i+1).getCell(j));
				obj[i][j] = sheet.getRow(i+1).getCell(j).toString();
//				obj[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
				
		}
		
		}
		return obj;
	}
	
	public static String generateRandom() {
		return RandomStringUtils.randomAlphanumeric(8);
	}

}
