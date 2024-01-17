package com.kraftechnologie.tests.day20_ddf;

import com.kraftechnologie.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    @Test
    public void readExcelFile() {
        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/Book.xlsx", "Sheet1");

        //how many rows in the sheet
        System.out.println("excelUtil.rowCount() = " + excelUtil.rowCount());

        //how many columns in the sheet
        System.out.println("excelUtil.columnCount() = " + excelUtil.columnCount());

        //get all colum names
        List<String> columnsNames = excelUtil.getColumnsNames();
        System.out.println("columnsNames = " + columnsNames);

        //get all data in the list of string
        List<Map<String, String>> dataList = excelUtil.getDataList();
        System.out.println("dataList = " + dataList);

        //gat name of firt map--> muhammedName
        System.out.println("dataList.get(0).get(\"name\") = " + dataList.get(0).get("name"));

        //get the whole data as 2D array including firt row (titles)
        String[][] dataArray = excelUtil.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));

        //get the whole data as 2D array excluding first row(titles)
        String[][] dataArrayWithoutFirstRow = excelUtil.getDataArrayWithoutFirstRow();
        System.out.println("Arrays.deepToString(dataArrayWithoutFirstRow) = " + Arrays.deepToString(dataArrayWithoutFirstRow));

    }
}
