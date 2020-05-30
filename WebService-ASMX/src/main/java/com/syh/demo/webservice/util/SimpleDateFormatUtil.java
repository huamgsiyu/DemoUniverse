package com.syh.demo.webservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormatUtil
 *
 * @author HSY
 * @since 2020/05/12 12:47
 */
public class SimpleDateFormatUtil {
    /**
     * Date type transfer String type
     * @param format    String format
     * @param date      Date time
     * @return  String
     */
    public static String dateToString (String format, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * String type transfer Date type
     * @param format        turn to String format
     * @param dateString    String of date
     * @return  Date
     */
    public static Date stringToDate (String format, String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(dateString);
    }
}
