package com.vmware.NetworkOfGiving.dao;

import com.vmware.NetworkOfGiving.model.Gender;
import com.vmware.NetworkOfGiving.model.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class MssqlRegisteredDao implements RegisteredDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MssqlRegisteredDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Registered> getAllRegistered() {
        return jdbcTemplate.query("SELECT * FROM registered", new RegisteredMapper());
    }

    /**
     *
     * I use the RegisteredMapper instead of simply Registered.class,
     * because we need to map the columns
     * @param username
     * @return the result of the query
     */

    @Override
    public Registered getRegisteredByUsername(String username) {
        return jdbcTemplate.queryForObject("SELECT username, password, firstName, " +
                "lastName, age, gender,location" +
                " FROM registered WHERE username LIKE ?", new RegisteredMapper(), username);
    }

    @Override
    public void registerUser(Registered registered) {
        jdbcTemplate.update("INSERT INTO registered " +
                "(username,password,firstName,lastName,age,gender,location)" +
                "VALUES (?,?,?,?,?,?,?)"
                ,registered.getUsername()
                ,registered.getPassword()
                ,registered.getFirstName()
                ,registered.getLastName()
                ,registered.getAge()
                ,registered.getGender().toString()
                ,registered.getLocation()==""?"N/A":registered.getLocation());
    }

    private static final class RegisteredMapper implements RowMapper<Registered>
    {

        @Override
        public Registered mapRow(ResultSet resultSet, int i) throws SQLException {

            Registered registered = new Registered();
            registered.setUsername(resultSet.getString("username"));
            registered.setPassword(resultSet.getString("password"));
            registered.setFirstName(resultSet.getString("firstName"));
            registered.setLastName(resultSet.getString("lastName"));
            registered.setAge(resultSet.getInt("age"));
            registered.setGender(Gender.valueOf(resultSet.getString("gender")));
            registered.setLocation(resultSet.getString("location"));
            return registered;
        }
    }
}
