package com.syh.demo.itext.pdf.enums;

/**
 * DateFormatUtil
 *
 * @author HSY
 * @since 2020/05/12 12:59
 */
public enum DateFormatEnum {
    /**
     * 年份，例如：2020
     */
    YYYY("yyyy"),

    /**
     * 年份和月份，例如：202005
     */
    YYYY_MM("yyyyMM"),

    /**
     * 年份和月份，例如：2020-05
     */
    YYYY_MM_RAIL("yyyy-MM"),

    /**
     * 年份和月份，例如：2020.05
     */
    YYYY_MM_DOT("yyyy.MM"),

    /**
     * 年月日，例如：200512
     */
    YY_MM_DD("yyMMdd"),

    /**
     * 年月日，例如：20-05-12
     */
    YY_MM_DD_RAIL("yy-MM-dd"),

    /**
     * 年月日，例如：20.05.12
     */
    YY_MM_DD_DOT("yy.MM.dd"),

    /**
     * 年月日，例如：20200512
     */
    YYYY_MM_DD("yyyyMMdd"),

    /**
     * 年月日，例如：2020-05-12
     */
    YYYY_MM_DD_RAIL("yyyy-MM-dd"),

    /**
     * 年月日，例如：2020.05.12
     */
    YYYY_MM_DD_DOT("yyyy.MM.dd"),

    /**
     * 年月日，例如：2020年05月12日
     */
    YYYY_MM_DD_Chinese("yyyy年MM月dd日"),

    /**
     * 年月日时分，例如：202005121314
     */
    YYYY_MM_DD_HH_MM("yyyyMMddHHmm"),

    /**
     * 年月日时分，例如：20200512 13:14
     */
    YYYY_MM_DD_HH_MM_COLON("yyyyMMdd HH:mm"),

    /**
     * 年月日时分，例如：2020-05-12 13:14
     */
    YYYY_MM_DD_HH_MM_RAIL_COLON("yyyy-MM-dd HH:mm"),

    /**
     * 年月日时分，例如：2020.05.12 13:14
     */
    YYYY_MM_DD_HH_MM_DOT_COLON("yyyy.MM.dd HH:mm"),

    /**
     * 年月日，例如：2020年05月12日13时14分
     */
    YYYY_MM_DD_HH_MM_Chinese("yyyy年MM月dd日HH时mm分"),

    /**
     * 年月日时分秒，例如：20200512131410
     */
    YYYY_MM_DD_HH_MM_SS("yyyyMMddHHmmss"),

    /**
     * 年月日时分秒，例如：20200512 13:14:10
     */
    YYYY_MM_DD_HH_MM_SS_COLON("yyyyMMdd HH:mm:ss"),

    /**
     * 年月日时分秒，例如：2020-05-12 13:14:10
     */
    YYYY_MM_DD_HH_MM_SS_RAIL_COLON("yyyy-MM-dd HH:mm:ss"),

    /**
     * 年月日时分秒，例如：2020.05.12 13:14:10
     */
    YYYY_MM_DD_HH_MM_SS_DOT_COLON("yyyy.MM.dd HH:mm:ss"),

    /**
     * 年月日，例如：2020年05月12日13时14分10秒
     */
    YYYY_MM_DD_HH_MM_SS_Chinese("yyyy年MM月dd日HH时mm分ss秒"),

    /**
     * 年月日时分秒，例如：20200512131410150
     */
    YYYY_MM_DD_HH_MM_SS_SSS("yyyyMMddHHmmssSSS"),

    /**
     * 年月日时分秒，例如：20200512 13:14:10:150
     */
    YYYY_MM_DD_HH_MM_SS_SSS_COLON("yyyyMMdd HH:mm:ss:SSS"),

    /**
     * 年月日时分秒，例如：2020.05.12 13:14:10:150
     */
    YYYY_MM_DD_HH_MM_SS_SSS_RAIL_COLON("yyyy-MM-dd HH:mm:ss:SSS"),

    /**
     * 年月日时分秒，例如：2020.05.12 13:14:10:150
     */
    YYYY_MM_DD_HH_MM_SS_SSS_DOT_COLON("yyyy.MM.dd HH:mm:ss:SSS"),

    /**
     * 年月日，例如：2020年05月12日13时14分10秒150毫秒
     */
    YYYY_MM_DD_HH_MM_SS_SSS_Chinese("yyyy年MM月dd日HH时mm分ss秒sss毫秒"),
    /**
     * 星期几，例如：星期一
     */
    WEEK("EEEE"),
    /**
     * 时分，例如：17:55
     */
    MM_SS("HH:mm"),
    /**
     * 时分秒，例如：12:00:00
     */
    HH_MM_SS_COLON("HH:mm:ss");

    public String format;

    DateFormatEnum(){}

    DateFormatEnum(String format) {
        this.format = format;
    }
}
