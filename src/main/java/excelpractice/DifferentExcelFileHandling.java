package excelpractice;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DifferentExcelFileHandling {
	

	
	
	@DataProvider(name="datasendingmethod")
	public static String[][] usingdiffexcel() throws IOException {
		
		
	        String[][] ab= ExcelSelenium.excelfilereading("seleniumbootexcel");
	        return ab;
	
	
	}
	
	

}
