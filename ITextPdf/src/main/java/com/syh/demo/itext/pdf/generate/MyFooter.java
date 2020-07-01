package com.syh.demo.itext.pdf.generate;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.syh.demo.itext.pdf.enums.DateFormatEnum;
import com.syh.demo.itext.pdf.util.SimpleDateFormatUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MyFooter
 *
 * @author HSY
 * @since 2020/07/01 18:02
 */
public class MyFooter extends PdfPageEventHelper {

    private static Font headerFont;
    static {
        BaseFont font = null;
        try {
            font = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        headerFont = new Font(font, 6, Font.NORMAL);
    }

    @lombok.SneakyThrows
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        // 页眉
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = simpleDateFormat.format(new Date());
        Phrase header = new Phrase(date + "中国联通云护理系统（管理端）", headerFont);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                header,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.top() + 10, 0);

        // 页脚
        Phrase footer = new Phrase("第一页", headerFont);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10, 0);
    }
}

