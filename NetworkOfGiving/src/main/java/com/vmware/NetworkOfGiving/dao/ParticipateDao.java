package com.vmware.NetworkOfGiving.dao;

public interface ParticipateDao {

    void participateIn(String username, int charityId);

    //void removeParticipation(String username, int charityId);

}
