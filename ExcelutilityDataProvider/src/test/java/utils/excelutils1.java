 


package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutils1 {
	
	static XSSFWorkbook workbook ;  //global static variables that can be called from other function without creating an object of class
	static XSSFSheet sheet;
	
	public excelutils1(String excelpath, String sheetname) throws IOException{       //constructor that will called automatically whenever object of class is called in main method and excelpath and sheet name will be asked

	workbook = new XSSFWorkbook(excelpath);
	sheet = workbook.getSheet(sheetname);
			
	}

	public static int getRowCount() throws IOException{
		
		int rowcount =0;
	    rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("no of rows : "+rowcount);
		 return rowcount;
			
	}
	
	  
	public static String  getCellData(int rowNum, int colNum) throws IOException{
        String celldata = null; 
		//function to get row data	
	
		celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println(celldata);
		return celldata;	
	}
    public static int getColCount() throws IOException{
		
		int colcount=0;
	    colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("no of columns : "+colcount);
		return colcount;	
	}
}
