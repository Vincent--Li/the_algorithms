package com.algorithm.vincent.newdateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        System.out.println("now 方法");
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localTime: " + localTime);
        System.out.println("localDate: " + localDate);
        System.out.println("localDateTime " + localDateTime);

        System.out.println("of 方法不可变");
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 12, 19,18,36,6,369);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        System.out.println("getXXX 方法");
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int hour = localTime.getHour();
        System.out.println("current date: " +
                year + "-" +
                month + "-" +
                day + "-" +
                hour + "-" +
                localTime.getMinute() + "-" +
                localTime.getSecond()
        );

        System.out.println("-----------withXxx()方法---------");
        LocalDateTime localDateTime2 = localDateTime.withYear(2020);
        System.out.println(localDateTime1);   //2016-09-01T12:20:18.000000256
        System.out.println(localDateTime2);   //2020-06-08T08:05:58.464

        /*plusXxx(value):增加某个属性的值，负数为减  返回新的对象*/
        System.out.println("-----------plusXxx(value)方法---------");
        LocalDateTime localDateTime3 = localDateTime2.plusYears(1);
        System.out.println(localDateTime3);  //2021-06-08T08:05:58.464

        /*minusXxx(value):减少某个属性的值，负数为加 返回新的对象*/
        System.out.println("-----------minusXxx(value)方法---------");
        LocalDateTime localDateTime4 = localDateTime2.minusYears(1);
        System.out.println(localDateTime4);  //2019-06-08T08:05:58.464



    }
}
