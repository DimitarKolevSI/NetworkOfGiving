package com.vmware.NetworkOfGiving.dao;

import com.vmware.NetworkOfGiving.model.Charity;

import java.util.List;

public interface CharityDao {

    void createCharity(Charity charity);

    //void deleteCharity(Charity charity);

    void deleteCharity(int id);

    List<Charity> getAllCharities();

    List<Charity> searchCharity(String key);

}
