package com.vmware.NetworkOfGiving.dao;

import com.vmware.NetworkOfGiving.model.Registered;

import java.util.List;
import java.util.Optional;

public interface RegisteredDao {

    public List<Registered> getAllRegistered();

    public Registered getRegisteredByUsername(String username);

    public void registerUser(Registered registered);


}
