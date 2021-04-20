package com.algorithm.vincent;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class DemoObject {

    public DemoObject(String accountingStatus){
        this.accountingStatus = accountingStatus;
    }
    private String accountingStatus;

    public String getAccountingStatus() {
        return accountingStatus;
    }

    public DemoObject setAccountingStatus(String accountingStatus) {
        this.accountingStatus = accountingStatus;
        return this;
    }
}
