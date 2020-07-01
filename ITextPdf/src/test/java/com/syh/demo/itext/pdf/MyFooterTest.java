package com.syh.demo.itext.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.syh.demo.itext.pdf.generate.MyFooter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * MyFooterTest
 *
 * @author HSY
 * @since 2020/07/01 18:03
 */
public class MyFooterTest {

    @Test
    public void test () throws FileNotFoundException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter instance = PdfWriter.getInstance(document, new FileOutputStream("有页眉.pdf"));
        // step 3
        document.open();
        MyFooter myFooter = new MyFooter();
        myFooter.onEndPage(instance, document);
        // step 4
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            msg.append("Hello World!");
        }
        document.add(new Paragraph(msg.toString()));
        // step 5
        document.close();

    }
}
