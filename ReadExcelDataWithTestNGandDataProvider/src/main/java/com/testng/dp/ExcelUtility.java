package com.testng.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFWorkbook excelWbook;
	private static XSSFSheet excelSheet;

	public static void setExcelFile(String path, String sheetName) throws IOException {
		try {
			FileInputStream excelFile = new FileInputStream(path);
			excelWbook = new XSSFWorkbook(excelFile);
			excelSheet = excelWbook.getSheet(sheetName);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static String[][] getTestData() {
		String[][] testData = null;
		int row = excelSheet.getLastRowNum() + 1;
		int column = excelSheet.getRow(0).getLastCellNum();
		testData = new String[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				testData[i][j] = excelSheet.getRow(i).getCell(j).getStringCellValue();

			}
		}
		return testData;
	}

}
