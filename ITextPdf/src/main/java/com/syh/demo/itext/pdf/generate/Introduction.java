package com.syh.demo.itext.pdf.generate;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 入门
 *
 * @author HSY
 * @since 2020/07/01 17:31
 */
public class Introduction {

    /**
     * iText入门
     * @param filename  pdf文件名
     * @throws FileNotFoundException    文件没找到异常
     * @throws DocumentException    文档异常
     */
    public static void introduction (String filename) throws FileNotFoundException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("Hello World!"));
        // step 5
        document.close();
    }



    public void manipulatePdf(String src, String dest)
            throws DocumentException, IOException {
        PdfReader reader = new PdfReader(src);
        Rectangle pagesize = reader.getPageSize(1);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        Paragraph p = new Paragraph();
        p.add(new Chunk("Hello "));
        p.add(new Chunk("World", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
        AcroFields form = stamper.getAcroFields();
        Rectangle rect = form.getFieldPositions("body").get(0).position;
        int status;
        PdfImportedPage newPage = null;
        ColumnText column = new ColumnText(stamper.getOverContent(1));
        column.setSimpleColumn(rect);
        int pagecount = 1;
        for (int i = 0; i < 100; ) {
            i++;
            column.addElement(new Paragraph("Hello " + i));
            column.addElement(p);
            status = column.go();
            if (ColumnText.hasMoreText(status)) {
                newPage = loadPage(newPage, reader, stamper);
                triggerNewPage(stamper, pagesize, newPage, column,
                        rect, ++pagecount);
            }
        }
        stamper.setFormFlattening(true);
        stamper.close();
        reader.close();
    }

    public PdfImportedPage loadPage(
            PdfImportedPage page, PdfReader reader, PdfStamper stamper) {
        if (page == null) {
            return stamper.getImportedPage(reader, 1);
        }
        return page;
    }

    public void triggerNewPage(PdfStamper stamper, Rectangle pagesize,
                               PdfImportedPage page, ColumnText column, Rectangle rect, int pagecount)
            throws DocumentException {
        stamper.insertPage(pagecount, pagesize);
        PdfContentByte canvas = stamper.getOverContent(pagecount);
        canvas.addTemplate(page, 0, 0);
        column.setCanvas(canvas);
        column.setSimpleColumn(rect);
        column.go();
    }

}
