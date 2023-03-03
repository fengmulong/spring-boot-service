package com.lyd.util;

import java.io.File;

/**
 * @author liyudong
 */
public class ExcelToPng {

    public static File ConvertPng(String excelFilePath, String pngFilePath){
        /*Workbook workbook = new Workbook();
        workbook.loadFromFile(excelName);
        Worksheet sheet = workbook.getWorksheets().get(0);*/
        File file=new File(pngFilePath);
        /*sheet.saveToImage(file.getPath());*/
        return file;
    }
}
