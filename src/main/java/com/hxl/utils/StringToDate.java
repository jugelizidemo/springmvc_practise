package com.hxl.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2019/6/28.
 */
public class StringToDate implements Converter<String,Date>  {

    @Override
    public Date convert(String source) {
        if (source == null || source.length() == 0)
            throw new RuntimeException("请传入数据");

        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        try{
           return df.parse(source);
        }catch (Exception e){
            throw new RuntimeException("解析日期异常");
        }


    }
}
