package com.vmware.NetworkOfGiving.service;

import com.vmware.NetworkOfGiving.dao.MssqlRegisteredDao;
import com.vmware.NetworkOfGiving.model.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisteredService {

    private final MssqlRegisteredDao mssqlRegisteredDao;

    @Autowired
    public RegisteredService(MssqlRegisteredDao mssqlRegisteredDao) {
        this.mssqlRegisteredDao = mssqlRegisteredDao;
    }

    public List<Registered> getAllRegistered()
    {
        return mssqlRegisteredDao.getAllRegistered();
    }

    /**
     *
     * @param username
     * @return null if there is no such user
     * @return registered if there is user with this username
     */

    public Registered getRegisteredByUsername(String username)
    {
        Registered registered;
        try{
            registered = mssqlRegisteredDao.getRegisteredByUsername(username);
            if(registered==null) throw new Exception();
        } catch (Exception e) {
            System.out.println("There is no such user!");
            return null;
        }
        return registered;
    }

    public void registerUser(Registered registered)
    {
        mssqlRegisteredDao.registerUser(registered);
    }
}
