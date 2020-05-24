package com.vmware.NetworkOfGiving.service;

import com.vmware.NetworkOfGiving.dao.MssqlParticipateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipateService {

    private final MssqlParticipateDao mssqlParticipateDao;

    @Autowired
    public ParticipateService(MssqlParticipateDao mssqlParticipateDao) {
        this.mssqlParticipateDao = mssqlParticipateDao;
    }

    public void participateIn(String username, int charityId)
    {
        mssqlParticipateDao.participateIn(username, charityId);
    }
}
