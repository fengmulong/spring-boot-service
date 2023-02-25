package com.step.template.main.util;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liyudong
 */
public class ExcelToPng {

    public static File ConvertPng(String excelFilePath,String pngFilePath){
        Workbook workbook = new Workbook();
        workbook.loadFromFile(excelName);
        Worksheet sheet = workbook.getWorksheets().get(0);
        File file=new File(pngFilePath);
        sheet.saveToImage(file.getPath());
        return file;
    }
}
