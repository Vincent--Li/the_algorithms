package com.algorithm.vincent.factoryexample.factory;

import com.algorithm.vincent.factoryexample.entity.EmployeeRecord;
import com.algorithm.vincent.factoryexample.entity.Employee;
import com.algorithm.vincent.factoryexample.exception.InvalidEmployeeType;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public interface EmployeeFactory {
    public Employee makeEmployee(EmployeeRecord record) throws InvalidEmployeeType;
}
