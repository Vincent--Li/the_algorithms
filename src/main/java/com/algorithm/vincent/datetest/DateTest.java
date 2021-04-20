package com.algorithm.vincent.datetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class DateTest {

    public static void main(String[] args) {
        Date dateFrom = DateTest.getDateFrom("", "");
        System.out.println(dateFrom);

        Date dateTo = DateTest.getDateTo("","");
        System.out.println(dateTo);
    }

    public static Date getDateFrom(String dateStr, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (!StringUtils.isEmpty(dateStr)) {
            try {
                return sdf.parse(dateStr);
            } catch (ParseException var4) {
//                logger.info(var4.getMessage());
            }
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        calendar.set(5, 1);
        return calendar.getTime();
    }

    public static Date getDateTo(String dateStr, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        if (!StringUtils.isEmpty(dateStr)) {
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException var5) {
//                logger.info(var5.getMessage());
            }
        }

        if (Objects.isNull(date)) {
            date = new Date();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(5, calendar.get(5) + 1);
        return calendar.getTime();
    }

}

class StringUtils {
    public static boolean isEmpty(String str){
        if(null == str || "".equals(str)){
            return true;
        }
        else {
            return false;
        }
    }

}
