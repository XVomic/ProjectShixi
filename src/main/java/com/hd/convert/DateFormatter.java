package com.hd.convert;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class DateFormatter implements Formatter<Date> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //将字符串转换成日期格式
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return dateFormat.parse(s);
    }

    //将日期格式数据转换成字符串
    @Override
    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }
}
