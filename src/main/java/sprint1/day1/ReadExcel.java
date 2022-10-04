package sprint1.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public  String[][] excelData(String excelfilename) throws IOException {

		XSSFWorkbook wb= new XSSFWorkbook(excelfilename);
		XSSFSheet ws = wb.getSheet("sheet1");
		
		int rowNum= ws.getLastRowNum();
		int lastColumn = ws.getRow(0).getLastCellNum();
		
		String[][] data= new String[rowNum][lastColumn];
		
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<lastColumn;j++) {
				
				//XSSFRow row= ws.getRow(i);
				// cell= row.getCell(j);
				String cellValue= ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=cellValue;
			}
		}
		
		wb.close();
		return data;
		
		
	}

}
