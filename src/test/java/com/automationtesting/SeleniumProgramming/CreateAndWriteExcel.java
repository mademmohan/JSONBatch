package com.automationtesting.SeleniumProgramming;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateAndWriteExcel {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("TestData");

		sheet.createRow(0);

		sheet.getRow(0).createCell(0).setCellValue("Hello");
		sheet.getRow(0).createCell(1).setCellValue("Testing");

		sheet.createRow(1);

		sheet.getRow(1).createCell(0).setCellValue("World");

		sheet.getRow(1).createCell(1).setCellValue("World");

		File file = new File("C:\\Users\\MADEM\\Desktop\\JSN.xlsx");

		FileOutputStream fi = new FileOutputStream(file);

		workbook.write(fi);

		System.out.println("Execution completed");

	}

}
