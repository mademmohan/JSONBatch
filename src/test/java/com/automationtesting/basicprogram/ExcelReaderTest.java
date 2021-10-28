package com.automationtesting.basicprogram;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderTest {

	private static final int NUMERIC = 0;
	private static final int STRING = 1;
	private static final int BOOLEAN = 2;

	public static void main(String[] args) throws IOException {

		FileInputStream fi = new FileInputStream("D:\\Practice.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet("Test");

		int rowcount = sheet.getPhysicalNumberOfRows();

		for (int i = 0; i < rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			int cellcount = row.getPhysicalNumberOfCells();

			for (int j = 0; j < cellcount; j++) {
				XSSFCell cell = row.getCell(j);
				String celldata = getCellvalue(cell);
				System.out.print("||" + celldata);

			}
			System.out.println();
		}

	}

	public static String getCellvalue(XSSFCell cell) {
		switch (cell.getCellType()) {
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());

		case STRING:
			return String.valueOf(cell.getStringCellValue());

		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());

		default:
			return cell.getStringCellValue();
		}
	}

}
