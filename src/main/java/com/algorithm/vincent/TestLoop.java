package com.algorithm.vincent;

import java.math.BigDecimal;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class TestLoop {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");

        Date date = df.parse("2021-01-31");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);

        System.out.println(df.format(calendar.getTime()));

    }

    static class Course {
        private String cname;

        public Course setCname(String cname) {
             this.cname = cname;
             return this;
        }

        public String getCname(){
            return this.cname;
        }
    }

}
