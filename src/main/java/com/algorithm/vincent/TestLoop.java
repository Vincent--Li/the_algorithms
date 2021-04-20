package com.algorithm.vincent;

import java.math.BigDecimal;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class TestLoop {
    public static void main(String[] args) {
//        List<DemoObject> objects = new ArrayList<>();
//        objects.add(new DemoObject("ABC"));
//        objects.add(new DemoObject("DEF"));
//        objects.add(new DemoObject("GHI"));
//
//        objects.parallelStream().forEach(x -> {
//            switch ("ACCOUNTED_ERROR"){
//                case Constants.FeedAccountStatus.ACCOUNTED_SUCCESS:
//                    if("1" == Constants.AccountingStatus.FORWARD_ACCOUNT){
//                        x.setAccountingStatus(Constants.AccountingStatus.ACCOUNTED);
//                    }else if("-1" == Constants.AccountingStatus.REV_ACCOUNT){
//                        x.setAccountingStatus(Constants.AccountingStatus.REV_ACCOUNTED);
//                    }
//                    break;
//                case Constants.FeedAccountStatus.ACCOUNTED_ERROR:
//                    if("1" == Constants.AccountingStatus.FORWARD_ACCOUNT){
//                        x.setAccountingStatus(Constants.AccountingStatus.ACCOUNTED_ERROR);
//                    }else if("-1" == Constants.AccountingStatus.REV_ACCOUNT){
//                        x.setAccountingStatus(Constants.AccountingStatus.REV_ACCOUNTED_ERROR);
//                    }
//
//                    break;
//                default:
//                    break;
//            }
//        });
//
//        objects.forEach(x -> System.out.println(x.getAccountingStatus()));
//        String str1 = "Student";
//        String str2 = new String("Student");
//        System.out.println(str1 == str2);
//        BigDecimal bigDecimal = BigDecimal.ZERO;
//        System.out.println(bigDecimal.add(new BigDecimal(5)));
//        System.out.println(bigDecimal.plus());
//        System.out.println(bigDecimal);

        int i = 0;
        for(; i < 5; i++){

        }
        System.out.println(i);
    }

    static class FeedBackDTO {

    }

}
