package com.algorithm.vincent.jsonconvertion;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class JsonConvertDemo {

    public static void main(String[] args) {
        String json = "{\n" +
                "\t\"batchNum\": \"0634f926-5fa1-473c-b749-9a417405ce04\",\n" +
                "\t\"context\": [{\n" +
                "\t\t\"oaNo\": \"1\",\n" +
                "\t\t\"reason\": null,\n" +
                "\t\t\"salerName\": \"曹宇\",\n" +
                "\t\t\"customerAddressName\": \"北京\",\n" +
                "\t\t\"insideCustomerSection\": \"0\",\n" +
                "\t\t\"sourceDataNo\": \"20000001070\",\n" +
                "\t\t\"factoryNo\": null,\n" +
                "\t\t\"taxInTotalPrice\": 0E-8,\n" +
                "\t\t\"spGoodsNo\": \"10010400010\",\n" +
                "\t\t\"realInspecteQty\": \"0.00000000\",\n" +
                "\t\t\"deptNo\": \"0303010105\",\n" +
                "\t\t\"odoLineNo\": \"2\",\n" +
                "\t\t\"odoNo\": \"SCOU48597630691765\",\n" +
                "\t\t\"stockUnitNo\": \"A03\",\n" +
                "\t\t\"lineNo\": \"0\",\n" +
                "\t\t\"projectNo\": \"\",\n" +
                "\t\t\"exchangeRate\": \"1\",\n" +
                "\t\t\"channelCategoryNo\": \"商超\",\n" +
                "\t\t\"financeUnitNo\": \"6350\",\n" +
                "\t\t\"inspecteNo\": \"SCYS48597630684763\",\n" +
                "\t\t\"unitId\": \"KG\",\n" +
                "\t\t\"taxInMainUnitPrice\": 6.00000000,\n" +
                "\t\t\"batchNumber\": \"LOT20000001081\",\n" +
                "\t\t\"currencyNo\": \"CNY\",\n" +
                "\t\t\"baseTaxExTotalPrice\": 0E-8,\n" +
                "\t\t\"enterpriseNo\": \"6350\",\n" +
                "\t\t\"inspecteTime\": \"2021-04-15 18:05:18\",\n" +
                "\t\t\"dataType\": \"1\",\n" +
                "\t\t\"sbuCode\": \"11010201\",\n" +
                "\t\t\"customerInspecteNo\": \"YS09012312\",\n" +
                "\t\t\"insideCustomer\": \"N\",\n" +
                "\t\t\"salesOrderType\": \"普通销售订单\",\n" +
                "\t\t\"exchangeRateType\": \"用户\",\n" +
                "\t\t\"taxRate\": 0.0900,\n" +
                "\t\t\"taxExMainUnitPrice\": 5.50458716,\n" +
                "\t\t\"exchangeRateDate\": \"2021-04-15\",\n" +
                "\t\t\"realGoodsLevel\": \"A03_05\",\n" +
                "\t\t\"customerPoNo\": \"20000000660\",\n" +
                "\t\t\"outWarehouseNo\": \"SS0004\",\n" +
                "\t\t\"customerAddressNo\": \"DF00222234C001\",\n" +
                "\t\t\"salerNo\": \"11015\",\n" +
                "\t\t\"tenantId\": \"0\",\n" +
                "\t\t\"salesNo\": \"SCSO48597630689385\",\n" +
                "\t\t\"baseTaxInUnitPrice\": 6.00000000,\n" +
                "\t\t\"contractCode\": \"1\",\n" +
                "\t\t\"baseTaxExUnitPrice\": 5.50458716,\n" +
                "\t\t\"customerNo\": \"DF00222234\"\n" +
                "\t}, {\n" +
                "\t\t\"oaNo\": \"1\",\n" +
                "\t\t\"reason\": null,\n" +
                "\t\t\"salerName\": \"曹宇\",\n" +
                "\t\t\"customerAddressName\": \"北京\",\n" +
                "\t\t\"insideCustomerSection\": \"0\",\n" +
                "\t\t\"sourceDataNo\": \"20000001075\",\n" +
                "\t\t\"factoryNo\": null,\n" +
                "\t\t\"taxInTotalPrice\": 0E-8,\n" +
                "\t\t\"spGoodsNo\": \"10010400010\",\n" +
                "\t\t\"realInspecteQty\": \"0.00000000\",\n" +
                "\t\t\"deptNo\": \"0303010105\",\n" +
                "\t\t\"odoLineNo\": \"2\",\n" +
                "\t\t\"odoNo\": \"SCOU48597630691765\",\n" +
                "\t\t\"stockUnitNo\": \"A03\",\n" +
                "\t\t\"lineNo\": \"1\",\n" +
                "\t\t\"projectNo\": \"\",\n" +
                "\t\t\"exchangeRate\": \"1\",\n" +
                "\t\t\"channelCategoryNo\": \"商超\",\n" +
                "\t\t\"financeUnitNo\": \"6350\",\n" +
                "\t\t\"inspecteNo\": \"SCYS48597630684763\",\n" +
                "\t\t\"unitId\": \"KG\",\n" +
                "\t\t\"taxInMainUnitPrice\": 6.00000000,\n" +
                "\t\t\"batchNumber\": \"LOT20000001076\",\n" +
                "\t\t\"currencyNo\": \"CNY\",\n" +
                "\t\t\"baseTaxExTotalPrice\": 0E-8,\n" +
                "\t\t\"enterpriseNo\": \"6350\",\n" +
                "\t\t\"inspecteTime\": \"2021-04-15 18:05:18\",\n" +
                "\t\t\"dataType\": \"1\",\n" +
                "\t\t\"sbuCode\": \"11010201\",\n" +
                "\t\t\"customerInspecteNo\": \"YS09012312\",\n" +
                "\t\t\"insideCustomer\": \"N\",\n" +
                "\t\t\"salesOrderType\": \"普通销售订单\",\n" +
                "\t\t\"exchangeRateType\": \"用户\",\n" +
                "\t\t\"taxRate\": 0.0900,\n" +
                "\t\t\"taxExMainUnitPrice\": 5.50458716,\n" +
                "\t\t\"exchangeRateDate\": \"2021-04-15\",\n" +
                "\t\t\"realGoodsLevel\": \"A03_05\",\n" +
                "\t\t\"customerPoNo\": \"20000000660\",\n" +
                "\t\t\"outWarehouseNo\": \"SS0004\",\n" +
                "\t\t\"customerAddressNo\": \"DF00222234C001\",\n" +
                "\t\t\"salerNo\": \"11015\",\n" +
                "\t\t\"tenantId\": \"0\",\n" +
                "\t\t\"salesNo\": \"SCSO48597630689385\",\n" +
                "\t\t\"baseTaxInUnitPrice\": 6.00000000,\n" +
                "\t\t\"contractCode\": \"1\",\n" +
                "\t\t\"baseTaxExUnitPrice\": 5.50458716,\n" +
                "\t\t\"customerNo\": \"DF00222234\"\n" +
                "\t}, {\n" +
                "\t\t\"oaNo\": \"1\",\n" +
                "\t\t\"reason\": null,\n" +
                "\t\t\"salerName\": \"曹宇\",\n" +
                "\t\t\"customerAddressName\": \"北京\",\n" +
                "\t\t\"insideCustomerSection\": \"0\",\n" +
                "\t\t\"sourceDataNo\": \"20000001076\",\n" +
                "\t\t\"factoryNo\": null,\n" +
                "\t\t\"taxInTotalPrice\": 33.02752294,\n" +
                "\t\t\"spGoodsNo\": \"10010400011\",\n" +
                "\t\t\"realInspecteQty\": \"40.00000000\",\n" +
                "\t\t\"deptNo\": \"0303010105\",\n" +
                "\t\t\"odoLineNo\": \"1\",\n" +
                "\t\t\"odoNo\": \"SCOU48597630691765\",\n" +
                "\t\t\"stockUnitNo\": \"A03\",\n" +
                "\t\t\"lineNo\": \"2\",\n" +
                "\t\t\"projectNo\": \"\",\n" +
                "\t\t\"exchangeRate\": \"1\",\n" +
                "\t\t\"channelCategoryNo\": \"商超\",\n" +
                "\t\t\"financeUnitNo\": \"6350\",\n" +
                "\t\t\"inspecteNo\": \"SCYS48597630684763\",\n" +
                "\t\t\"unitId\": \"KG\",\n" +
                "\t\t\"taxInMainUnitPrice\": 10.00000000,\n" +
                "\t\t\"batchNumber\": \"LOT20000001065\",\n" +
                "\t\t\"currencyNo\": \"CNY\",\n" +
                "\t\t\"baseTaxExTotalPrice\": 33.02752294,\n" +
                "\t\t\"enterpriseNo\": \"6350\",\n" +
                "\t\t\"inspecteTime\": \"2021-04-15 18:05:18\",\n" +
                "\t\t\"dataType\": \"1\",\n" +
                "\t\t\"sbuCode\": \"11010201\",\n" +
                "\t\t\"customerInspecteNo\": \"YS09012312\",\n" +
                "\t\t\"insideCustomer\": \"N\",\n" +
                "\t\t\"salesOrderType\": \"普通销售订单\",\n" +
                "\t\t\"exchangeRateType\": \"用户\",\n" +
                "\t\t\"taxRate\": 0.0900,\n" +
                "\t\t\"taxExMainUnitPrice\": 9.17431193,\n" +
                "\t\t\"exchangeRateDate\": \"2021-04-15\",\n" +
                "\t\t\"realGoodsLevel\": \"A03_05\",\n" +
                "\t\t\"customerPoNo\": \"20000000660\",\n" +
                "\t\t\"outWarehouseNo\": \"SS0004\",\n" +
                "\t\t\"customerAddressNo\": \"DF00222234C001\",\n" +
                "\t\t\"salerNo\": \"11015\",\n" +
                "\t\t\"tenantId\": \"0\",\n" +
                "\t\t\"salesNo\": \"SCSO48597630689385\",\n" +
                "\t\t\"baseTaxInUnitPrice\": 10.00000000,\n" +
                "\t\t\"contractCode\": \"1\",\n" +
                "\t\t\"baseTaxExUnitPrice\": 9.17431193,\n" +
                "\t\t\"customerNo\": \"DF00222234\"\n" +
                "\t}],\n" +
                "\t\"interfaceName\": \"AR_JD_SO_OUTCHECK\",\n" +
                "\t\"sourceSystem\": \"JD\"\n" +
                "}";

        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray context = jsonObject.getJSONArray("context");
        List<Map<String, Object>> data = (List) JSONArray.parseObject(context.toJSONString(), List.class);
        Iterator var2 = data.iterator();

        while(var2.hasNext()) {
            Map<String, Object> mapList = (Map)var2.next();
            Iterator var4 = mapList.entrySet().iterator();

            while(var4.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)var4.next();
                if (Objects.nonNull(entry.getValue())) {
                    if("baseTaxExTotalPrice".equals(entry.getKey())){
                        if(entry.getValue() instanceof BigDecimal){
                            System.out.println(((BigDecimal) entry.getValue()).toPlainString());

                        }
                        System.out.println(entry.getValue().getClass().getName());
                    }
                    mapList.put(entry.getKey(), entry.getValue().toString());
                }
            }
        }

    }
}
