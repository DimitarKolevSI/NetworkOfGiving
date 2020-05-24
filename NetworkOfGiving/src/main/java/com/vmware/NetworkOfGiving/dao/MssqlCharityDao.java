package com.vmware.NetworkOfGiving.dao;

import com.vmware.NetworkOfGiving.model.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MssqlCharityDao implements CharityDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MssqlCharityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createCharity(Charity charity) {
        jdbcTemplate.update("INSERT INTO charity " +
                        "(title, description, volunteersNeeded,volunteers,moneyNeeded,moneyDonated,creatorsUsername) " +
                        "VALUES " +
                        "(?,?,?,?,?,?,?)",
                charity.getTitle(),
                charity.getDescription(),
                charity.getVolunteersNeeded(),
                charity.getVolunteers(),
                charity.getMoneyNeeded(),
                charity.getMoneyDonated(),
                charity.getCreatorsUsername());
    }

    @Override
    public void deleteCharity(int id) {
        jdbcTemplate.update("DELETE FROM charity WHERE id LIKE ?",id);
        jdbcTemplate.update("DELETE FROM participateIn WHERE charityId LIKE ?",id);
        jdbcTemplate.update("DELETE FROM donateTo WHERE charityId LIKE ?",id);
    }

    @Override
    public List<Charity> getAllCharities() {
        return jdbcTemplate.query("SELECT * FROM charity", new CharityMapper());
    }

    @Override
    public List<Charity> searchCharity(String key) {
        return jdbcTemplate.query("SELECT id,title, description, volunteersNeeded, volunteers, " +
                "moneyNeeded, moneyDonated,creatorsUsername FROM charity WHERE title LIKE ?",new CharityMapper(),"%"+key+"%");
    }

    private static final class CharityMapper implements RowMapper<Charity>
    {

        @Override
        public Charity mapRow(ResultSet resultSet, int i) throws SQLException {
            Charity charity = new Charity();
            charity.setId(resultSet.getInt("id"));
            charity.setTitle(resultSet.getString("title"));
            charity.setDescription(resultSet.getString("description"));
            charity.setVolunteersNeeded(resultSet.getInt("volunteersNeeded"));
            charity.setVolunteers(resultSet.getInt("volunteers"));
            charity.setMoneyNeeded(resultSet.getDouble("moneyNeeded"));
            charity.setMoneyDonated(resultSet.getDouble("moneyDonated"));
            charity.setCreatorsUsername(resultSet.getString("creatorsUsername"));

            return charity;
        }
    }
}
