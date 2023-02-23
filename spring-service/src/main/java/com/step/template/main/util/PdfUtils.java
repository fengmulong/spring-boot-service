package com.step.template.main.util;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.PdfImageType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author liyudong
 */
public class PdfUtils {

    public static void ConvertToPng(String pdfFIlePath,String pngFilePath) {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(pdfFIlePath);
        for (int i = 0; i < pdf.getPages().getCount(); i++) {
            BufferedImage image = pdf.saveAsImage(i, PdfImageType.Bitmap, 500, 500);
            //File file = new File("C:\\Users\\Administrator\\Desktop\\PDFToImages" + "/" + String.format(("ToImage-img-%d.png"), i));
            File file = new File(pngFilePath);
            try {
                ImageIO.write(image, "PNG", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        pdf.close();
    }

    public static void ConvertToWord(String pdfFIlePath,String wordFilePath) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(pdfFIlePath);
        doc.saveToFile(wordFilePath, FileFormat.DOC);
        //doc.saveToFile(wordFilePath, FileFormat.DOCX);
        doc.close();
    }
}
