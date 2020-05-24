package com.vmware.NetworkOfGiving.service;

import com.vmware.NetworkOfGiving.dao.MssqlDonateToDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonateService {

    private final MssqlDonateToDao mssqlDonateToDao;

    @Autowired
    public DonateService(MssqlDonateToDao mssqlDonateToDao) {
        this.mssqlDonateToDao = mssqlDonateToDao;
    }

    public void donateTo(String username, int charityId, double donation)
    {
        mssqlDonateToDao.donateTo(username, charityId, donation);
    }
}
