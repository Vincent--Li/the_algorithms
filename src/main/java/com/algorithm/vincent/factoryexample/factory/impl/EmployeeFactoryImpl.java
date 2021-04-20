package com.algorithm.vincent.factoryexample.factory.impl;

import com.algorithm.vincent.factoryexample.constants.EmployeeConstants;
import com.algorithm.vincent.factoryexample.entity.*;
import com.algorithm.vincent.factoryexample.exception.InvalidEmployeeType;
import com.algorithm.vincent.factoryexample.factory.EmployeeFactory;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class EmployeeFactoryImpl implements EmployeeFactory {
    @Override
    public Employee makeEmployee(EmployeeRecord record) throws InvalidEmployeeType {
        switch (record.getType()){
            case EmployeeConstants.COMMISSIONED:
                return new CommissionedEmployee(record);
            case EmployeeConstants.HOURLY:
                return new HourlyEmployee(record);
            case EmployeeConstants.SALARIED:
                return new SalariedEmployee(record);
            default:
                throw new InvalidEmployeeType();
        }
    }
}
