package com.wys.chats.util;


/**
 * 格式化常量
 * Created by HuangKai on 2017/8/29.
 */
public class Format {
    public static final DateFormat DATE_FORMAT=new DateFormat();
    public static final RegexFormat REGEX_FORMAT=new RegexFormat();
    public static final Character CHARACTER=new Character();

    /**
     * 日期格式常量
     */
    public static class DateFormat{
        public final String YYYY_MM_DD_HH_MM_ss="yyyy-MM-dd HH:mm:ss";
        public final String YYYY_MM_DD="yyyy-MM-dd";
        public final String MM_DD_HH_MM="MM-dd HH:mm";
        public final String HH_MM_ss="HH:mm:ss";
        public final String YYYYMMDD="yyyyMMdd";
        public final String YYYYMMDDHHMMSS="yyyyMMddHHmmss";
        public final String HHMMss="HHmmss";
        public final String HANDOVER_YYYY_MM_DD_END="yyyy年MM月dd日交班";
        public final String HANDOVER_YYYY_MM_DD_BEGIN="yyyy年MM月dd日到";
    }
    /**
     * 正则表达式常量
     */
    public static class RegexFormat{
        public final String HANDOVER_TEMPLET_VAR="[{][{][a-zA-Z0-9_]{1,}[}][}]";
        public final String MYBATIS_SQL_PARAMETER="\\#\\{[a-zA-Z0-9_.]*\\}";
        public final String SPACE_COMMA =",";
    }
    /**
     * 字符常量
     */
    public static class Character{
        public final String FRASL ="/";
    }
}
