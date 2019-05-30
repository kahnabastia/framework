package com.learnautomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		File src=new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("unable to read Excel 	file"+e.getMessage());
		}
	}

	public String  getStringIndex(int sheetIndex,int rowNum,int colNum) {
		return wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	
	public String  getStringData(String sheetName,int rowNum,int colNum) {
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	public double getNumericData(String sheetName,int rowNum,int colNum) {
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue();
	}

}
