package com.epam.programsportalautomation.framework;


import com.epam.programsportalautomation.pojo.College;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

import static com.epam.programsportalautomation.constants.ExcelPaths.COLLEGE_DETAILS_EXCELSHEET;
import static com.epam.programsportalautomation.constants.ExcelPaths.EXCEL_PATH;

public class ExcelResusableFunctions {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private XSSFCell cell;
    private XSSFRow row;

    public  ExcelResusableFunctions(String excelpath){
        try {
            workbook = new XSSFWorkbook(excelpath);
            workbook.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void setSheet(String sheetName) {
        this.sheet = workbook.getSheet(sheetName);
    }

     public String getNumericCellData(int rowNum, int colNum){
        return sheet.getRow(rowNum).getCell(colNum).getRawValue();
     }
    public String getStringCellData(int rowNum, int colNum){
        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
    }


    public static int getRowCount(){
        return sheet.getLastRowNum();
    }
    public static int getColCount(){
        return sheet.getRow(0).getLastCellNum();
    }
    public Object[][] getDetails(String sheetName) {
        setSheet(sheetName);
        int rowNum = getRowCount();
        int colNum = getColCount();
        Object data[][] = new Object[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                    data[i][j] = getCellData(sheetName,i + 1, j);
            }
        }
        return data;
    }
    public String getCellData(String sheetName, int rowNum, int colNum) {
        String cellData  =  " ";
        if(rowNum==-1)
            return cellData;
        row = workbook.getSheet(sheetName).getRow(rowNum);
        cell = row.getCell(colNum);
        if(row==null)
            return cellData;
        else if (cell==null)
            return cellData;
        else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA)
            cellData = String.valueOf(getNumericCellData(rowNum,colNum));
        else if (cell.getCellType() == CellType.STRING)
            cellData = getStringCellData(rowNum,colNum);
        else if (cell.getCellType() == CellType.BLANK)
            cellData = " ";
        else if (cell.getCellType() == CellType.BOOLEAN)
            cellData = String.valueOf(cell.getBooleanCellValue());
        return cellData;
    }

    public static College getCollegeInfoFromExcelSheet() throws IOException {
        College college = new College();
         workbook = new XSSFWorkbook(EXCEL_PATH);
         sheet = workbook.getSheet(COLLEGE_DETAILS_EXCELSHEET);
            college.setCollegeName(sheet.getRow(1).getCell(0).getStringCellValue());
                college.setCollegeCity(sheet.getRow(1).getCell(1).getStringCellValue());
                college.setCollegeGroup(sheet.getRow(1).getCell(2).getStringCellValue());
                college.setCollegePtoName(sheet.getRow(1).getCell(3).getStringCellValue());
                college.setCollegePtoEmail(sheet.getRow(1).getCell(4).getStringCellValue());
        return college;
    }

}
