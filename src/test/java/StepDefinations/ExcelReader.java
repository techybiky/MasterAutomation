package StepDefinations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

import gherkin.formatter.model.Row;

public class ExcelReader {
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\User\\Desktop\\TestData.xlsx"; // Change path as needed
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

//		int rowCount = sheet.getPhysicalNumberOfRows();
//		for (int i = 0; i < rowCount; i++) {
//			Row row = sheet.getRow(i);
//			int cellCount = row.getPhysicalNumberOfCells();
//			for (int j = 0; j < cellCount; j++) {
//				Cell cell = row.getCell(j);
//				System.out.print(cell.toString() + " | ");
//			}
//			System.out.println();
//		}
//		workbook.close();
//		fis.close();
	}
}
