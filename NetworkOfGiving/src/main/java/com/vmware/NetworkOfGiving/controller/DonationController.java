package com.vmware.NetworkOfGiving.controller;

import com.vmware.NetworkOfGiving.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donation")
public class DonationController {

    private final DonateService donateService;

    @Autowired
    public DonationController(DonateService donateService) {
        this.donateService = donateService;
    }

    @PostMapping(path = "/{username}/{charityId}/{donation}")
    public void donateTo(@PathVariable("username") String username, @PathVariable("charityId") int id, @PathVariable("donation") double donation)
    {
        this.donateService.donateTo(username, id, donation);
    }


}
