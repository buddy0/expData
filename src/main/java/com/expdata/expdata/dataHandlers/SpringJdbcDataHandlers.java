package com.expdata.expdata.dataHandlers;

import com.expdata.expdata.pojo.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


@Component
public class SpringJdbcDataHandlers  implements IDataHandlers {

    @Override
    public List<Employee> getEmployees(String name) throws ClassNotFoundException, SQLException {

        DataSource dataSource =
                new DriverManagerDataSource("jdbc:mysql://localhost:3306/hello","root", "Buddy1234");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Employee> result = jdbcTemplate.query(getQueryFetchEmployees(name), (rs, ind) -> {
            return new Employee(rs.getString("email"), rs.getString("name"));
        });

        return result;
    }

    @Override
    public void addEmployees(Employee employee) throws ClassNotFoundException, SQLException {
        DataSource dataSource =
                new DriverManagerDataSource("jdbc:mysql://localhost:3306/hello","root", "Buddy1234");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(getQueryAddEmployees(employee));

    }
}

