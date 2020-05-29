package com.vmware.NetworkOfGiving.service;

import com.vmware.NetworkOfGiving.dao.MssqlCharityDao;
import com.vmware.NetworkOfGiving.model.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityService {

    private final MssqlCharityDao mssqlCharityDao;

    @Autowired
    public CharityService(MssqlCharityDao mssqlCharityDao) {
        this.mssqlCharityDao = mssqlCharityDao;
    }

    public void createCharity(Charity charity)
    {
        mssqlCharityDao.createCharity(charity);
    }

    public void deleteCharity(int id)
    {
        mssqlCharityDao.deleteCharity(id);
    }

    public List<Charity> getAllCharities()
    {
        return mssqlCharityDao.getAllCharities();
    }

    public List<Charity> searchCharity(String key)
    {
        return mssqlCharityDao.searchCharity(key);
    }

    public Charity getCharityByTitle(String title){
        return mssqlCharityDao.getCharityByTitle(title);
    }

}
