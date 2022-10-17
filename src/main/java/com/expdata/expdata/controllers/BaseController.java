package com.expdata.expdata.controllers;


import com.expdata.expdata.Util;
import com.expdata.expdata.dataHandlers.IDataHandlers;
import com.expdata.expdata.dataHandlers.JdbcDataHandlers;
import com.expdata.expdata.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.sql.*;
import java.util.List;

@RestController
public class BaseController {

    @Autowired
    @Qualifier("jdbcDataHandlers")
    IDataHandlers dataHandlers;

    @GetMapping("/getRandom")
    public Employee getRandom() {
        Employee employee = new Employee();
        employee.setEmail(Util.generateStr(6));
        employee.setName(Util.generateStr(6));
        return employee;
    }

    @GetMapping("/getEmployee/{name}")
    public List<Employee> get(@PathVariable String name) throws ClassNotFoundException, SQLException {
        return dataHandlers.getEmployees(name);
    }

    @PostMapping("/addEmployee")
    public String add(@RequestBody Employee employee) throws ClassNotFoundException, SQLException {
        dataHandlers.addEmployees(employee);
        return employee.getName() + ":" + employee.getEmail();
    }
}
