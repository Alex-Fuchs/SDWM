package com.siltronic.diversity.data_access.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.siltronic.diversity.data_access.dao.EmployeeDAO;

@Repository
public class EmployeeRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    class EmployeeRowMapper implements RowMapper<EmployeeDAO> {

        @Override
        public EmployeeDAO mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new EmployeeDAO(rs.getInt("id"), rs.getString("firstName"), rs.getString("secondName"), rs.getString("birthPlace"));
        }
    }
    
    public List <EmployeeDAO> findByCountry(String name) {
    	return new ArrayList<>(jdbcTemplate.query(
                "select * from Employee Where birthPlace =? ", new Object[] { name }, new EmployeeRowMapper()));
    }
    
    public List <EmployeeDAO> findByEntry(String entry) {
    	String[] list = entry.split(" ");
    	if (list.length > 1) {	
    		return new ArrayList<>(jdbcTemplate.query(
                    "select * from Employee Where firstName Like ? or SecondName Like ?", new Object[] { "%" + list[0] + "%", "%" + list[list.length - 1] + "%"}, new EmployeeRowMapper()));
    	} else {
    	entry = "%" + entry + "%";
    	return new ArrayList<>(jdbcTemplate.query(
                "select * from Employee Where firstName Like ? or SecondName Like ?", new Object[] { entry, entry }, new EmployeeRowMapper()));
    	}
    }

    public int insert(String firstName, String secondName, String birthPlace) {
        return jdbcTemplate.update("insert into Employee " +
                        "(firstName, secondName, birthPlace) " + "values (?, ?, ?)", firstName, secondName, birthPlace);
    }
}

