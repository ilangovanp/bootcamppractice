package excelpractice;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.common.usermodel.HyperlinkType;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ExcelSelenium {

	

	public static String[][] excelfilereading(String fileName) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowNumber=sheet.getLastRowNum();
		int colnumber= sheet.getRow(1).getLastCellNum();
		System.out.println(rowNumber);
		System.out.println(colnumber);
		
		 String values[][]= new String[rowNumber][colnumber];
		for (int i = 1; i <=rowNumber; i++) {
			//System.out.println("|");
			for(int j=0;j<colnumber;j++) {
			
			String txt =sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.println(txt);
			values[i-1][j]=txt;
		}
		
}
		workbook.close();
return values;
		
		
		
}
	
}
