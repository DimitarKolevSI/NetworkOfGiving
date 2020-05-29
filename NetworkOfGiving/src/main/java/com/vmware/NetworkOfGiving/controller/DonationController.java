package com.vmware.NetworkOfGiving.controller;

import com.vmware.NetworkOfGiving.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donation")
public class DonationController {

    private final DonateService donateService;

    @Autowired
    public DonationController(DonateService donateService) {
        this.donateService = donateService;
    }

    @CrossOrigin
    @PostMapping(path = "/{username}/{charityId}/{donation}")
    public void donateTo(@PathVariable("username") String username, @PathVariable("charityId") int id, @PathVariable("donation") double donation)
    {
        System.out.println("Donating");
        this.donateService.donateTo(username, id, donation);
    }
}
