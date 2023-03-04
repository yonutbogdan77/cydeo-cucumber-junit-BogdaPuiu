package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReading {
    @Test
    public void read_from_Excel() throws IOException {
        String path = "SampleData.xlsx";
// to read from Excel we need to load it to FileInputStream
        FileInputStream fileInputStream= new FileInputStream(path);
        //workbook-->sheet-->row-->cell
        XSSFWorkbook workbook= new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Employees");
        // select row and cell Index start from 0
        System.out.println(sheet.getRow(1).getCell(0));
// print out developer
        System.out.println(sheet.getRow(3).getCell(2));



    }
}
