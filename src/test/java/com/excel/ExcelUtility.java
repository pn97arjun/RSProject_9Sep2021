package com.excel;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    public ExcelUtility(String path,String sheetName)
    {
        try
        {
            workbook=new XSSFWorkbook(path);
            sheet=workbook.getSheet(sheetName);
        }
        catch (Exception e)
        {
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public void getRowCount()
    {

        int rowCount=sheet.getPhysicalNumberOfRows();
        System.out.println(rowCount);
    }
    public void getCellValue(int rowValue,int ColValue)
    {
        DataFormatter dataFormatter=new DataFormatter();
        Object value=dataFormatter.formatCellValue(sheet.getRow(rowValue).getCell(ColValue));
        //Object value=sheet.getRow(rowValue).getCell(ColValue).getStringCellValue();
        System.out.println(value);
    }


}
