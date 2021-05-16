package com.epam.programsportalautomation.dataproviders;

import java.io.IOException;

import com.epam.programsportalautomation.framework.ExcelResusableFunctions;
import com.epam.programsportalautomation.pojo.College;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import static com.epam.programsportalautomation.constants.ExcelPaths.*;

public class ExcelDataProvider {
    public ExcelDataProvider(String excelPath, String sheetName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        workbook.close();
    }
    public static String getCellDataOfCollegeCredentials(int rowNum, int colNum) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(EXCEL_PATH);
        XSSFSheet sheet = workbook.getSheet(COLLEGE_DETAILS_EXCELSHEET);
        String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        return data;
    }

    @DataProvider(name = "AddCollegeDetailsFromExcelSheet")
    public static Object[][] enterAddCollegeDetailsFromExcel(){
        Object data[][] = new ExcelResusableFunctions(EXCEL_PATH).getDetails(COLLEGE_DETAILS_EXCELSHEET);
        return data;
    }

    @DataProvider(name = "SearchCollegeMail")
    public static Object[][] enterAddCollegePtoMailFromExcel(){
        Object data[][] = new ExcelResusableFunctions(EXCEL_PATH).getDetails(COLLEGE_MAIL_SEARCH_EXCELSHEET);
        return data;
    }
}
