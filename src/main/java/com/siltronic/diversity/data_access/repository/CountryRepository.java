package com.siltronic.diversity.data_access.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.siltronic.diversity.data_access.dao.CountryDAO;

@Repository
public class CountryRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    class CountryRowMapper implements RowMapper<CountryDAO> {

        @Override
        public CountryDAO mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new CountryDAO(rs.getString("id"), rs.getString("name"));
        }
    }

    public List <CountryDAO> findAll() {
        return new ArrayList<>(jdbcTemplate.query(
                "select * from Country", new CountryRowMapper()));
    }
    
    public List <CountryDAO> findAllSort() {
        return new ArrayList<>(jdbcTemplate.query(
                "select * from Country Order By name", new CountryRowMapper()));
    }
    
    public CountryDAO findByName(String name) {
    	return jdbcTemplate.queryForObject(
                "select * from Country Where name =? ", new Object[] { name }, new CountryRowMapper());
    }
}
