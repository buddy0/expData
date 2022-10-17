package com.expdata.expdata.dataHandlers;

import com.expdata.expdata.pojo.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IDataHandlers {
    public  List<Employee> getEmployees(String name) throws ClassNotFoundException, SQLException ;

    public  void addEmployees(Employee employee) throws ClassNotFoundException, SQLException ;

    public default String getQueryFetchEmployees(String name) {
        return String.format("select * from Employee where name like \"%%%s%%\"", name);
    }

    public default String getQueryAddEmployees(Employee employee) {
        return String.format("insert into Employee values(\"%s\", \"%s\");", employee.getEmail(), employee.getName());
    }


}
