package com.expdata.expdata.dataHandlers;

import com.expdata.expdata.pojo.Employee;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDataHandlers implements IDataHandlers {

    public  List<Employee> getEmployees(String name) throws ClassNotFoundException, SQLException {
        //1. Load and register the driver
        Class.forName("com.mysql.jdbc.Driver");

        //2. Create a connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","Buddy1234");

        //3. Create a statement.
        Statement st = connection.createStatement();
        String query = getQueryFetchEmployees(name);

        //4. Execution of query
        ResultSet resultSet = st.executeQuery(query);

        List<Employee> result = new ArrayList<>();

        //5. Processing of result
        while (resultSet.next()) {
            result.add(new Employee(resultSet.getString("email"), resultSet.getString("name")));
        }

        //6.Close
        st.close();
        connection.close();

        return result;

    }

    public  void addEmployees(Employee employee) throws ClassNotFoundException, SQLException {
        //1. Load and register the driver
        Class.forName("com.mysql.jdbc.Driver");

        //2. Create a connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","Buddy1234");

        //3. Create a statement.
        Statement st = connection.createStatement();
        String query = getQueryAddEmployees(employee);

        //4. Execution of query
        st.executeUpdate(query);
        //ResultSet resultSet = st.executeQuery(query);

        //6.Close
        st.close();
        connection.close();

    }
}
