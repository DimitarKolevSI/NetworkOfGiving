package com.vmware.NetworkOfGiving.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class MssqlParticipateDao implements ParticipateDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MssqlParticipateDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void participateIn(String username, int charityId) {
        int maxParticipants = jdbcTemplate.queryForObject("SELECT volunteersNeeded FROM charity WHERE id LIKE ?",Integer.class,charityId);
        int participant = jdbcTemplate.queryForObject("SELECT volunteers FROM charity WHERE id LIKE ?",Integer.class,charityId);
        if(participant>= maxParticipants)
        {
            System.out.println("No more participants needed!");
            return;
        }
        jdbcTemplate.update("INSERT INTO participateIn (username, charityId) VALUES (?,?)",username,charityId);
        jdbcTemplate.update("UPDATE charity SET volunteers = volunteers + 1 WHERE id LIKE ?",charityId);
    }
}
