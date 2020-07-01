package com.syh.demo.itext.pdf;

import com.itextpdf.text.DocumentException;
import com.syh.demo.itext.pdf.generate.Introduction;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * IntroductionTest
 *
 * @author HSY
 * @since 2020/07/01 17:29
 */
public class IntroductionTest {

    @Test
    public void introduction () throws DocumentException, FileNotFoundException {
        Introduction.introduction("helloWord.pdf");
    }
}
