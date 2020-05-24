package com.vmware.NetworkOfGiving.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class MssqlDonateToDao implements DonateToDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MssqlDonateToDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void donateTo(String username, int charityId, double donation) {
        double maxDonation = jdbcTemplate.queryForObject("SELECT moneyNeeded FROM charity WHERE id LIKE ?",Double.class,charityId);
        double amountOfDonations = jdbcTemplate.queryForObject("SELECT moneyDonated FROM charity WHERE id LIKE ?",Double.class,charityId);
        double currentDonation = (maxDonation-amountOfDonations) < donation?(maxDonation-amountOfDonations):donation;
        if(currentDonation == 0)
        {
            System.out.println("No more donations needed!");
            return;
        }
        jdbcTemplate.update("INSERT INTO donateTo (username, charityId, donation) VALUES (?,?,?)",username,charityId,currentDonation);
        jdbcTemplate.update("UPDATE charity SET moneyDonated = moneyDonated + ? WHERE id LIKE ?",currentDonation,charityId);
    }

}
