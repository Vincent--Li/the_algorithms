package com.algorithm.vincent;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class PatternTest {

    public static Pattern NUMBER_PATTERN = Pattern.compile("^[-+]?[0-9]+(\\.[0-9]+)?$");
    private static final Pattern AUXILIARY_ITEM_PATTERN = Pattern.compile("\\u3010[\\u4e00-\\u9fa5a-zA-Z0-9]+\\uff1a[\\S]+\\u3011");
    public static void main(String[] args) {

//        Matcher matcher = AUXILIARY_ITEM_PATTERN.matcher("【银行账户：中国农业银行方正县支行（专户）】");
//        while(matcher.find()) {
//            System.out.println(matcher.group(0));
//        }
        ArrayList<String> auxiliaryItem = new ArrayList<>();
        String auxiliaryItemString = "【银行账户：中国农业银行哈尔滨市中山支行】\n";
        while(auxiliaryItemString.indexOf("】")>0){
            int start = auxiliaryItemString.indexOf("【");
            int end = auxiliaryItemString.indexOf("】");
            auxiliaryItem.add(auxiliaryItemString.substring(start, end + 1));
            auxiliaryItemString = auxiliaryItemString.substring(end + 1);
        }

        auxiliaryItem.stream().forEach(item->{
            System.out.println(item);
            String[] split = item.substring(1, item.length() - 1).split("：");
            System.out.println("项目辅助核算".equalsIgnoreCase(split[0]));
            System.out.println(split[1]);
        });
    }
}
