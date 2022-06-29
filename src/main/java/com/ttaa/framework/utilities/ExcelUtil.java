package com.ttaa.framework.utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelUtil {

    static Sheet wrksheet;
    static Workbook wrkbook = null;
    static Hashtable dict = new Hashtable();

    public ExcelUtil(String ExcelSheetPath) throws BiffException, IOException {
        wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));
        wrksheet = wrkbook.getSheet("Sheet1");

        ColumnDictionary();
    }

    public static int RowCount(){
        return wrksheet.getRows();
    }

    private static String ReadCell(int column, int row){
        return wrksheet.getCell(column, row).getContents();
    }

    public static String ReadCell(String columnName, int row){
        return ReadCell(GetCell(columnName), row);
    }

    private static int GetCell(String columnName) {
        try{
            int value;
            value = ((Integer) dict.get(columnName)).intValue();
            return value;
        }
        catch (NullPointerException e){
            return 0;
        }
    }

    private void ColumnDictionary() {
        for(int col=0; col < wrksheet.getColumns(); col++){
            dict.put(ReadCell(col, 0), col);
        }
    }
}
