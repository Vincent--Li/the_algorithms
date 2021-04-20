package com.algorithm.vincent.newdateapi;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class InstantTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);


        //处理为中国时区: 东8区
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取毫秒数
        Long mills = instant.toEpochMilli();
        System.out.println(mills);

        // 将毫秒数转化为Instant
        Instant instant1 = Instant.ofEpochMilli(1592267462055L);
        System.out.println(instant1);

        // date to instant
        Instant instant2 = new Date().toInstant();
        System.out.println(instant2);
    }
}
