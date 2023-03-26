package Lecture_05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class pgm_01_ExcelData {

	
	@DataProvider(name = "datafromExcel")
	public Object[][] readExcelData() throws Exception
	{
		
		File file = new File("/home/mangeshs/eclipse-workspace/RestAssuredProjectArtifactID/ExcelData/Test.xls");
		FileInputStream fis = new FileInputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("XLS format");
		int noofrows  = sheet.getPhysicalNumberOfRows();
		int noofCol = sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(noofrows);
		System.out.println(noofCol);
		
		String data[][] = new String[noofrows][noofCol];

		
		for(int i = 1 ; i < noofrows ; i ++)
		{
		for(int j =0 ;  j < noofCol;j++)
			{
			
			DataFormatter df = new DataFormatter();
            data[i][j]= df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		return data;			
	}
	
}
