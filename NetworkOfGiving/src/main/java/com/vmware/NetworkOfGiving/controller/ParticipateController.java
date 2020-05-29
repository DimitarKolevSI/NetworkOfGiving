package com.vmware.NetworkOfGiving.controller;

import com.vmware.NetworkOfGiving.service.ParticipateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/participate")
public class ParticipateController {

    private final String LOCAL_HOST_URL = "http://localhost:4200";
    private final ParticipateService participateService;

    @Autowired
    public ParticipateController(ParticipateService participateService) {
        this.participateService = participateService;
    }

    @CrossOrigin(origins = LOCAL_HOST_URL)
    @PostMapping(path = "/{username}/{charityId}")
    public void participateIn(@PathVariable("username") String username, @PathVariable("charityId") int charityId)
    {
        System.out.println("Participating in: " + charityId);
        participateService.participateIn(username, charityId);
    }
}
