package com.algorithm.vincent.factoryexample.entity;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class HourlyEmployee extends Employee {
    public HourlyEmployee(EmployeeRecord record) {
        System.out.println(record.getType());
    }

    @Override
    public boolean isPayDay() {
        return false;
    }

    @Override
    public Money calculatePay() {
        return null;
    }

    @Override
    public void deliverPay(Money pay) {

    }
}
