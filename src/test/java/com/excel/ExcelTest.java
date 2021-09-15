package com.excel;

public class ExcelTest {
    public static void main(String[] args)
    {
        String path="./data/excelSheet.xlsx";
        String sheetName="Sheet1";
        ExcelUtility excelUtility=new ExcelUtility(path,sheetName);
        excelUtility.getRowCount();
        excelUtility.getCellValue(1,2);
    }
}
