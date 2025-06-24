package main.java.utils;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataManipulation {

	public static XSSFWorkbook getWorkbook(String filepath) {
		XSSFWorkbook workBook = null;
		try {
			FileInputStream file = new FileInputStream(filepath);
			workBook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workBook;
	}

	public static int getRowCount(XSSFWorkbook workbook, int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getPhysicalNumberOfRows();
	}

	public static String getData(XSSFWorkbook workbook, int sheetIndex, int rowIndex, int cellIndex) {
		return workbook.getSheetAt(sheetIndex).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	}
}
